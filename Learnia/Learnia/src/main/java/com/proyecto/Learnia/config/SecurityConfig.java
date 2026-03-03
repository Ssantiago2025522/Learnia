package com.proyecto.Learnia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers("/api/usuario/**").permitAll()
                        .requestMatchers("/api/categorias/**").permitAll()
                        .requestMatchers("/api/comentarios/**").permitAll()
                        .requestMatchers("/api/preguntas/**").permitAll()
                        .requestMatchers("/api/respuestas/**").permitAll()
                        .requestMatchers("/api/votos/**").permitAll()
                        .anyRequest().authenticated()
                )
                .build();
    }
}
