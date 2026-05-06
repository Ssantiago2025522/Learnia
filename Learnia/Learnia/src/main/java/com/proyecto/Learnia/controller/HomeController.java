package com.proyecto.Learnia.controller;

import com.proyecto.Learnia.dto.PreguntaDTO;
import com.proyecto.Learnia.entity.Categoria;
import com.proyecto.Learnia.entity.Usuario;
import com.proyecto.Learnia.repository.CategoriaRepository;
import com.proyecto.Learnia.repository.UsuarioRepository;
import com.proyecto.Learnia.service.PreguntaService;
import com.proyecto.Learnia.entity.Pregunta;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    private final UsuarioRepository usuarioRepository;
    private final PreguntaService preguntaService;
    private final CategoriaRepository categoriaRepository;

    public HomeController(UsuarioRepository usuarioRepository,
                          PreguntaService preguntaService,
                          CategoriaRepository categoriaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.preguntaService = preguntaService;
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Pregunta> preguntas = preguntaService.listar();
        model.addAttribute("preguntas", preguntas);
        return "home";
    }

    @GetMapping("/menu")
    public String menu(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        Usuario usuario = usuarioRepository
                .findByCorreoUsuario(userDetails.getUsername())
                .orElseThrow();

        List<Pregunta> preguntas = preguntaService.listar();
        List<Categoria> categorias = categoriaRepository.findAll();

        model.addAttribute("usuario", usuario);
        model.addAttribute("preguntas", preguntas);
        model.addAttribute("categorias", categorias);

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
    public String preguntar(Model model) {
        model.addAttribute("preguntaDTO", new PreguntaDTO());
        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);
        return "preguntar";
    }

    @PostMapping("/preguntar")
    public String guardarPregunta(@ModelAttribute PreguntaDTO dto,
                                  @AuthenticationPrincipal UserDetails userDetails) {
        Usuario usuario = usuarioRepository
                .findByCorreoUsuario(userDetails.getUsername())
                .orElseThrow();
        dto.setIdUsuario(usuario.getIdUsuario());
        preguntaService.guardar(dto);
        return "redirect:/menu";
    }
}