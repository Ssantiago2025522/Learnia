package com.proyecto.Learnia.controller;

import com.proyecto.Learnia.entity.Respuesta;
import com.proyecto.Learnia.service.RespuestaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/respuesta")
public class RespuestaRestController {

    private final RespuestaService respuestaService;

    public RespuestaRestController(RespuestaService respuestaService) {
        this.respuestaService = respuestaService;
    }

    @GetMapping
    public List<Respuesta> listar() {
        return respuestaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> buscar(@PathVariable Long id) {
        Respuesta respuesta = respuestaService.buscarPorId(id);
        if (respuesta != null) {
            return ResponseEntity.ok(respuesta);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Respuesta> actualizar(@PathVariable Long id, @Valid @RequestBody Respuesta respuesta) {
        Respuesta actualizada = respuestaService.actualizar(id, respuesta);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        respuestaService.eliminar(id);
    }
}