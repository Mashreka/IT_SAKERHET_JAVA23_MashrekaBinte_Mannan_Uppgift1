package com.example.deliveryService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/api/users/create").permitAll() // Allow access to create user
                        .requestMatchers("/api/users/**").permitAll() // allow public access to user endpoints
                        .anyRequest().authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable); // Disable CSRF

        return http.build();
    }
}

