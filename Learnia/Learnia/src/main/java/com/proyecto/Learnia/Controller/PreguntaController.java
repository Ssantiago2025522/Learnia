package com.proyecto.Learnia.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.proyecto.Learnia.Entity.Pregunta;
import com.proyecto.Learnia.Service.PreguntaService;

@RestController
@RequestMapping("/preguntas")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    @GetMapping
    public List<Pregunta> listar() {
        return preguntaService.listar();
    }

    @PostMapping
    public Pregunta guardar(@RequestBody Pregunta pregunta) {
        return preguntaService.guardar(pregunta);
    }

    @GetMapping("/{id}")
    public Pregunta buscar(@PathVariable Long id) {
        return preguntaService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        preguntaService.eliminar(id);
    }

    @PutMapping("/{id}")
    public Pregunta actualizar(@PathVariable Long id,
                               @Valid @RequestBody Pregunta pregunta) {
        return preguntaService.actualizar(id, pregunta);
    }
}