package org.zerock.api01.security.filter;

import com.google.gson.Gson;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;
import org.zerock.api01.security.exception.RefreshTokenException;
import org.zerock.api01.util.JWTUtil;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
public class RefreshTokenFilter extends OncePerRequestFilter {
    private final String refreshPath;
    private final JWTUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 요청 url을 path 변수에 저장하고 취득
        String path = request.getRequestURI();
        // 요청 url이 refreshPath가 아니면 필터로 처리하지 않음
        if(!path.equals(refreshPath)) {
            log.info("skip refresh token filter........");
            filterChain.doFilter(request, response);
            return;
        }
        log.info("refresh token filter..........1.........");

        // 전송된 JSON에서 accessToken, refreshToken을 얻어옴
        Map<String ,String> tokens = parseRequestJSON(request);

        String accessToken = tokens.get("accessToken");
        String refreshToken = tokens.get("refreshToken");

        log.info("accessToken = " + accessToken);
        log.info("refreshToken = " + refreshToken);

        try{
            checkAccessToken(accessToken);
        } catch (RefreshTokenException refreshTokenException) {
            refreshTokenException.sendResponseError(response);
            return;
        }

        Map<String, Object> refreshClaims = null;

        try {
            refreshClaims = checkRefreshToken(refreshToken);
            log.info(refreshClaims);
            // refreshToken 의 유효시간이 얼마 남지 않은 경우
            Integer exp = (Integer) refreshClaims.get("exp");
            Date expTime = new Date(Instant.ofEpochMilli(exp).toEpochMilli() * 1000);
            Date current = new Date(System.currentTimeMillis());

            // 만료 시간과 현재 시간의 간격 계산
            // 3일 미만인 경우 refreshToken도 다시계산
            long gapTime = (expTime.getTime() - current.getTime());

            log.info("------------------------------------------------");
            log.info("current : " + current);
            log.info("expTime : "+ expTime);
            log.info("gap : "+ gapTime);

            String mid = (String) refreshClaims.get("mid");

            // AccessToken은 무조건 새로 생성
            String accessTokenValue = jwtUtil.generateToken(Map.of("mid",mid),1);
            String refreshTokenValue = tokens.get("refreshToken");

            // refreshToken이 3일미만으로 남았으면
            if(gapTime < (1000 * 60 * 60 * 24 * 3)) {
                log.info("new refresh token required...........................");
                refreshTokenValue = jwtUtil.generateToken(Map.of("mid",mid),30);
            }

            log.info("Refresh Token result....................................");
            log.info("accessToken : "+accessTokenValue);
            log.info("refreshToken : "+refreshTokenValue);

            sendTokens(accessTokenValue, refreshTokenValue , response);


        } catch (RefreshTokenException refreshTokenException) {
            refreshTokenException.sendResponseError(response);
            return;
        }

    }

    private Map<String ,String> parseRequestJSON(HttpServletRequest request) {
        try(Reader reader = new InputStreamReader(request.getInputStream())) {
            Gson gson = new Gson();
            return gson.fromJson(reader, Map.class);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    private void checkAccessToken(String accessToken) throws RefreshTokenException {
        try{
            jwtUtil.validateToken(accessToken);
        } catch (ExpiredJwtException e) {
            log.info("Access token has expired");
        } catch (Exception exception) {
            throw new RefreshTokenException(RefreshTokenException.ErrorCase.NO_ACCESS);
        }
    }

    private Map<String,Object> checkRefreshToken(String refreshToken) throws RefreshTokenException {
        try {
            Map<String,Object> values = jwtUtil.validateToken(refreshToken);
            return values;
        } catch (ExpiredJwtException e) {
            throw new RefreshTokenException(RefreshTokenException.ErrorCase.OLD_REFRESH);
        } catch (MalformedJwtException e) {
            log.error("MalformedJWTException...............");
            throw new RefreshTokenException(RefreshTokenException.ErrorCase.NO_REFRESH);
        } catch(Exception e){
            new RefreshTokenException(RefreshTokenException.ErrorCase.NO_REFRESH);
        }
        return null;
    }

    private void sendTokens(String accessTokenValue, String refreshTokenValue, HttpServletResponse response) {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(Map.of("accessToken",accessTokenValue,"refreshToken",refreshTokenValue));
        try {
            response.getWriter().println(jsonStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
