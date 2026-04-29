package com.proyecto.Learnia.controller;
import com.proyecto.Learnia.dto.LoginRequest;
import com.proyecto.Learnia.dto.LoginResponse;
import com.proyecto.Learnia.dto.RegisterRequest;
import com.proyecto.Learnia.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public  String register(@Valid  @RequestBody RegisterRequest req){
        authService.register(req);
        return "Usuario registado de manera correcta";
    }


    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest req){
        return authService.login(req);
    }
}
