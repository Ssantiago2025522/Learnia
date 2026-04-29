package com.proyecto.Learnia.controller;
import com.proyecto.Learnia.dto.LoginRequest;
import com.proyecto.Learnia.dto.LoginResponse;
import com.proyecto.Learnia.dto.RegisterRequest;
import com.proyecto.Learnia.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
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


    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
