package com.proyecto.Learnia.controller;

import com.proyecto.Learnia.repository.RecursoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/materias")
public class CursoController {

    private final RecursoRepository recursoRepository;

    public CursoController(RecursoRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    @GetMapping("/matematica")
    public String matematica(Model model) {

        model.addAttribute("recursos",
                recursoRepository.findByCategoria_IdCategoria(1L));

        return "cursos/matematica";
    }

    @GetMapping("/fisica")
    public String fisica(Model model) {

        model.addAttribute("recursos",
                recursoRepository.findByCategoria_IdCategoria(2L));

        return "cursos/fisica";
    }

    @GetMapping("/informatica")
    public String informatica(Model model) {

        model.addAttribute("recursos",
                recursoRepository.findByCategoria_IdCategoria(3L));

        return "cursos/informatica";
    }

    @GetMapping("/ingles")
    public String ingles(Model model) {

        model.addAttribute("recursos",
                recursoRepository.findByCategoria_IdCategoria(4L));

        return "cursos/ingles";
    }
}
