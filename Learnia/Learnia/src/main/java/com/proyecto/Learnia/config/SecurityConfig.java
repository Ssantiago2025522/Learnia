package com.proyecto.Learnia.config;
import com.proyecto.Learnia.entity.Usuario;
import com.proyecto.Learnia.repository.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/login", "/register", "/css/**", "/js/**", "/img/**", "/uploads/**"). permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/menu", true)
                        .usernameParameter("correoUsuario")
                        .passwordParameter("contrasenaUsuario")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return email -> {
            Usuario usuario = usuarioRepository.findByCorreoUsuario(email)
                    .orElseThrow(()-> new UsernameNotFoundException("Usuario no encontrado: " + email));

            return User.builder()
                    .username(usuario.getCorreoUsuario())
                    .password(usuario.getContrasenaUsuario())
                    .roles(usuario.getRolUsuario().name())
                    .build();
        };
    }


}
