package org.zerock.api01.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.zerock.api01.security.APIUserDetailsService;
import org.zerock.api01.security.filter.APILoginFilter;

@Configuration
@Log4j2
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class CustomSecurityConfig {

    private final APIUserDetailsService apiUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 암호화 설정
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        log.info("------------------web configure----------");
        // 정적 파일 요청을 무시하는 설정
        return (web -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations()));
    }

    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {

        // AuthenticationManager 설정 : 인증 관리자 생성을 위한 빌더 생성
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        // 인증 관리자 빌더를 사용하여 userDetailsService 설정과 passwordEncoder 설정
        authenticationManagerBuilder
                .userDetailsService(apiUserDetailsService)
                        .passwordEncoder(passwordEncoder());

        // Get AuthenticationManager : 인증 관리자 빌더를 통해 인증 관리자를 생성
        AuthenticationManager authenticationManager =
                authenticationManagerBuilder.build();

        http.authenticationManager(authenticationManager); // 반드시 필요한 부분 > http에 인증관리자를 설정

        // APILoginFilter 를 불러올 때 사용할 URL설정하기
        APILoginFilter apiLoginFilter = new APILoginFilter("/generateToken");
        // APILoginFilter 가 위에서 만든 인증 관리자를 사용하게끔 설정
        apiLoginFilter.setAuthenticationManager(authenticationManager);

        // APILoginFilter의 위치 조정 > APILoginFilter 전에 실행할 필터를 설정
        http.addFilterBefore(apiLoginFilter, UsernamePasswordAuthenticationFilter.class);

        //log.info("----------configure-------------");
        http.csrf().disable(); // csrf 설정 끄기
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 세션 생성 설정 끄기
        return http.build();
    }
}
