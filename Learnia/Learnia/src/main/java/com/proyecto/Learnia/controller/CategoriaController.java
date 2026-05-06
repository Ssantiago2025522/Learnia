package com.proyecto.Learnia.controller;

import com.proyecto.Learnia.entity.Categoria;
import com.proyecto.Learnia.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listar() {
        return categoriaService.listar();
    }

    @PostMapping
    public Categoria guardar(@Valid @RequestBody Categoria categoria) {
        return categoriaService.crear(categoria);
    }

    @GetMapping("/{id}")
    public Categoria obtener(@PathVariable Long id) {
        return categoriaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Categoria editar(@PathVariable Long id, @Valid @RequestBody Categoria categoria) {
        return categoriaService.actualizar(id, categoria);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        categoriaService.eliminar(Long.valueOf(id));
    }
}