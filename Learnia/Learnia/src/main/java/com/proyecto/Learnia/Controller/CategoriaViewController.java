package com.proyecto.Learnia.Controller;

import com.proyecto.Learnia.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoriaViewController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categorias")
    public String verCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.listar());
        return "categorias"; // templates/categorias.html
    }
}