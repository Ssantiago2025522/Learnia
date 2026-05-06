package com.proyecto.Learnia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/menu-usuario")
    public String menuUsuario() {
        return "menu-usuario"; // Carga templates/menu-usuario.html
    }

    @GetMapping("/menu-admin")
    public String menuAdmin() {
        return "menu-admin"; // Carga templates/menu-admin.html
    }
}