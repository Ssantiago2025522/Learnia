package com.proyecto.Learnia.controller;

import com.proyecto.Learnia.entity.Voto;
import com.proyecto.Learnia.service.VotoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/votos")
public class VotoController {

    private final VotoService votoService;

    public VotoController(VotoService votoService) {
        this.votoService = votoService;
    }

    @GetMapping
    public List<Voto> listar() {
        return votoService.listar();
    }

    @PostMapping
    public ResponseEntity<Voto> crear(@Valid @RequestBody Voto voto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(votoService.crear(voto));
    }

    @GetMapping("/{id}")
    public Voto buscar(@PathVariable Long id) {
        return votoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Voto actualizar(@PathVariable Long id,
                           @Valid @RequestBody Voto voto) {
        return votoService.actualizar(id, voto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        votoService.eliminar(id);
    }
}