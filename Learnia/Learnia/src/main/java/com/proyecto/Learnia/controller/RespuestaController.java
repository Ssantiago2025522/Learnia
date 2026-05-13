package com.proyecto.Learnia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.proyecto.Learnia.entity.Respuesta;
import com.proyecto.Learnia.service.RespuestaService;

@Controller
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @GetMapping
    public List<Respuesta> listar() {
        return respuestaService.listar();
    }

    @PostMapping
    public String guardar(@RequestParam String contenido,
                          @RequestParam Long preguntaId) {

        respuestaService.guardar(preguntaId, contenido);
        return "redirect:/feed";
    }

    @GetMapping("/{id}")
    public Respuesta buscarPorId(@PathVariable Long id) {
        return respuestaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Respuesta actualizar(@PathVariable Long id,
                                @RequestBody Respuesta respuesta) {
        return respuestaService.actualizar(id, respuesta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        respuestaService.eliminar(id);
    }

}