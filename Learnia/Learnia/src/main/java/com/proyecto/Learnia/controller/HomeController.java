package com.proyecto.Learnia.controller;

import com.proyecto.Learnia.entity.Usuario;
import com.proyecto.Learnia.repository.UsuarioRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final UsuarioRepository usuarioRepository;

    public HomeController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }



    @GetMapping("/")
    public String index() {

        return "home";
    }

    @GetMapping("/menu")
    public String menu(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        Usuario usuario = usuarioRepository.findByCorreoUsuario(userDetails.getUsername()).orElseThrow();
        model.addAttribute("usuario", usuario);
        return "menu-usuario";
    }

    @GetMapping("/usuario")
    public String vistaUsuario(Model model, @AuthenticationPrincipal UserDetails userDetails) {

        Usuario usuario = usuarioRepository
                .findByCorreoUsuario(userDetails.getUsername())
                .orElseThrow();

        model.addAttribute("usuario", usuario);

        return "usuarios-view";
    }

    @GetMapping("/preguntar")
    public String preguntar() {
        return "preguntar";
    }
}