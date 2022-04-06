package com.studyhae.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity // spring security 설정을 직접 다 하겠다
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 내가 원하는 특정 요청들은 security체크를 하지 않도록 해준다
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/", "/login", "/sign-up", "/check-email", "/check-email-token",
                        "/email-login", "/check-email-login", "/login-link").permitAll()
                .mvcMatchers(HttpMethod.GET, "/profile/*").permitAll() // 프로필은 왜 get으로는 인증 없이도 보여야 할까..?애초에 로그인 후 보여주는게 프로필 아니던가
                .anyRequest().authenticated();
    }
}
