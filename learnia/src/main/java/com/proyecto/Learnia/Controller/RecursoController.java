package com.proyecto.Learnia.Controller;

import com.proyecto.Learnia.Entity.Recurso;
import com.proyecto.Learnia.Entity.TipoRecurso;
import com.proyecto.Learnia.Service.RecursoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recurso")
public class RecursoController {

    private final RecursoService recursoService;

    public RecursoController(RecursoService recursoService) {
        this.recursoService = recursoService;
    }

    @GetMapping("/get")
    public List<Recurso> listar() {
        return recursoService.listar();
    }

    @PostMapping
    public ResponseEntity<Recurso> crear(@Valid @RequestBody Recurso recurso) {
        Recurso crear = recursoService.crearReC(recurso);
        return ResponseEntity.status(HttpStatus.CREATED).body(crear);
    }

    @GetMapping("/{id}")
    public Recurso buscar(@PathVariable Integer id) {
        return recursoService.buscarPorIdRec(id.longValue());
    }

    @PutMapping("/{id}")
    public Recurso actualizar(@PathVariable Integer id, @Valid @RequestBody Recurso recurso) {
        return recursoService.actualizarReC(id.longValue(), recurso);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        recursoService.eliminar(id.longValue());
    }

    @GetMapping("/usuario/{idUsuario}")
    public Recurso buscarUsuario(@PathVariable Long idUsuario) {
        return (Recurso) recursoService.buscarPorUsuario(idUsuario);
    }

    @GetMapping("/categoria/{idCategoria}")
    public Recurso buscarCategoria(@PathVariable Long idCategoria) {
        return (Recurso) recursoService.buscraPorCategoria(idCategoria);
    }

    @GetMapping("/tipo/{tipoRecurso}")
    public Recurso buscarTipo(@PathVariable TipoRecurso tipoRecurso) {
        return (Recurso) recursoService.buscarPorTipo(tipoRecurso);
    }

}
