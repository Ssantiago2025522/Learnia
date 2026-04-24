package com.proyecto.Learnia.controller;


import com.proyecto.Learnia.dto.RegisterRequest;
import com.proyecto.Learnia.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

 private final AuthService authService;

 public RegisterController(AuthService authService) {
     this.authService = authService;
 }

 @GetMapping
    public String form(Model model) {

     model.addAttribute("user", new RegisterRequest());
     return "register";
 }

    @PostMapping
    public String register(
            @Valid @ModelAttribute("usuario") RegisterRequest req,
            BindingResult result,
            Model model
    ) {

     if (result.hasErrors()) {
         return "register";
     }
     try {
         authService.register(req);
         model.addAttribute("proceso exitoso", "Usuario registrado correctamente");
     } catch (Exception e) {
         model.addAttribute("error", e.getMessage());
     }

     return "register";
    }

}
