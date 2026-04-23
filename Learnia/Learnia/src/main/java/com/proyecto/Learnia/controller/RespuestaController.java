package com.proyecto.Learnia.controller;

import com.proyecto.Learnia.dto.RespuestaDTO;
import com.proyecto.Learnia.entity.Respuesta;
import com.proyecto.Learnia.service.RespuestaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/respuestas")
public class RespuestaController {

    private final RespuestaService respuestaService;

    public RespuestaController(RespuestaService respuestaService) {
        this.respuestaService = respuestaService;
    }

    @GetMapping
    public List<Respuesta> listar() {
        return respuestaService.listar();
    }

    @PostMapping
    public ResponseEntity<Respuesta> crear(@Valid @RequestBody RespuestaDTO respuestaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(respuestaService.crear(respuestaDTO));
    }

    @GetMapping("/{id}")
    public Respuesta buscar(@PathVariable Long id) {
        return respuestaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Respuesta actualizar(@PathVariable Long id,
                                @Valid @RequestBody RespuestaDTO dto) {
        return respuestaService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        respuestaService.eliminar(id);
    }
}