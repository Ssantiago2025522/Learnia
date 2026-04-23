package com.proyecto.Learnia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Deshabilita la protección contra POST no autorizados
                .cors(AbstractHttpConfigurer::disable) // Deshabilita restricciones de origen
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // ABRE ABSOLUTAMENTE TODO
                );
        return http.build();
    }
}