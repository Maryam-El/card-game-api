package com.mycompany.cardgameapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) 
            .authorizeHttpRequests(requests -> requests
                .requestMatchers(new AntPathRequestMatcher("/api/games/**")).authenticated() 
                .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll() 
                .anyRequest().permitAll() 
            )
            .headers(headers -> headers
                .frameOptions(frameOptions -> frameOptions.disable()) 
            )
            .httpBasic(httpBasic -> {}); 

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}