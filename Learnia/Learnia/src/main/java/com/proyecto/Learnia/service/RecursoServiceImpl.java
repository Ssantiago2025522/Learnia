package com.proyecto.Learnia.service;

import com.proyecto.Learnia.entity.Recurso;
import com.proyecto.Learnia.entity.TipoRecurso;
import com.proyecto.Learnia.exception.ResourceNotFoundException;
import com.proyecto.Learnia.repository.RecursoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecursoServiceImpl implements RecursoService{

    public final RecursoRepository recursoRepository;

    public RecursoServiceImpl(RecursoRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }


    @Override
    public List<Recurso> listar() {
        return recursoRepository.findAll();
    }

    @Override
    public Recurso crearReC(Recurso recurso) {
        recurso.setFechaSubida(LocalDateTime.now());
        return recursoRepository.save(recurso);
    }

    @Override
    public Recurso buscarPorIdRec(Long id) {
        return recursoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso no encontrado por id: " + id));
    }

    @Override
    public Recurso actualizarReC(Long id, Recurso recurso) {
        Recurso existe = buscarPorIdRec(id);

        existe.setTituloRecurso(recurso.getTituloRecurso());
        existe.setDescripcionRecurso(recurso.getDescripcionRecurso());
        existe.setTipoRecurso(recurso.getTipoRecurso());
        existe.setUrlArchivo(recurso.getUrlArchivo());
        existe.setFechaSubida(recurso.getFechaSubida());
        existe.setCategoria(recurso.getCategoria());
        existe.setUsuario(recurso.getUsuario());
        return recursoRepository.save(existe);
    }

    @Override
    public void eliminar(Long id) {
        if (!recursoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso no encontrado por id: " + id);
        }
        recursoRepository.deleteById(id);
    }


}
