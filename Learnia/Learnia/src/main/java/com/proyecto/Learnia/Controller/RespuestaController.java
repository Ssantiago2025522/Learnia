package com.proyecto.Learnia.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.proyecto.Learnia.Entity.Respuesta;
import com.proyecto.Learnia.Service.RespuestaService;

@RestController
@RequestMapping("/api/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @GetMapping
    public List<Respuesta> listar() {
        return respuestaService.listar();
    }

    @PostMapping
    public Respuesta guardar(@RequestBody Respuesta respuesta) {
        return respuestaService.guardar(respuesta);
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