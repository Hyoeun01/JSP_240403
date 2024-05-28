package org.zerock.api01.security.filter;

import com.google.gson.Gson;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.filter.OncePerRequestFilter;
import org.zerock.api01.util.JWTUtil;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
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
        Map<String ,String> token = parseRequestJSON(request);

        String accessToken = token.get("accessToken");
        String refreshToken = token.get("refreshToken");

        log.info("accessToken = " + accessToken);
        log.info("refreshToken = " + refreshToken);
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
}
