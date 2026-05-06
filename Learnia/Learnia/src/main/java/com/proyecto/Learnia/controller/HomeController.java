package com.proyecto.Learnia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "home";
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu-usuario";
    }

    @GetMapping("/usuario")
    public String vistaUsuario() {
        return "usuarios-view";
    }

    @GetMapping("/preguntar")
    public String preguntar() {
        return "preguntar";
    }
}