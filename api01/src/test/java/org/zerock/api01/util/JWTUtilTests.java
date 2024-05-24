package org.zerock.api01.util;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
@Log4j2
public class JWTUtilTests {
    @Autowired
    private JWTUtil jwtUtil;

    @Test
    public void testGenerate(){
        Map<String, Object> claimMap = Map.of("mid","ABCDE");
        String jwtStr = jwtUtil.generateToken(claimMap,1);
        log.info(jwtStr);
    }

    @Test
    public void testValidate(){
        // 유효시간이 지난 토큰(ExpiredJwtException), 문자열에 임의 문자 추가(SignatureException)해서 오류확인하기
        String jwtStr = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MTY1Mjc5MzMsIm1pZCI6IkFCQ0RFIiwiaWF0IjoxNzE2NTI3ODczfQ1.dwdA9SOahvbTnnDVDCHyoTiu9RdlB44ACOC8D2mrUCs";

        Map<String, Object> claim = jwtUtil.validateToken(jwtStr);
        log.info(claim);
    }
}
