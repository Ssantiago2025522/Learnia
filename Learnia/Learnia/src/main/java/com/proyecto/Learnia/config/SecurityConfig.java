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
                        .requestMatchers("/api/auth/**").permitAll()    // Permite login y registro
                        .requestMatchers("/api/usuario/**").permitAll() // <-- ESTA ES LA LÍNEA QUE FALTA
                        .anyRequest().authenticated()                   // Cualquier otra ruta requiere login
                )
                .build();
    }
}
