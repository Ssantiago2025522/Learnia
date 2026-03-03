package com.humbertoperez.Learnia.Service;

import com.humbertoperez.Learnia.Entity.Recurso;
import com.humbertoperez.Learnia.Entity.TipoRecurso;
import com.humbertoperez.Learnia.Exception.ResourceNotFoundException;
import com.humbertoperez.Learnia.Repository.RecursoRepository;
import com.humbertoperez.Learnia.service.*
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursoServiceImpl implements RecursoService {


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

        return recursoRepository.save(existe);
    }

    @Override
    public void eliminar(Long id) {
        if (!recursoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso no encontrado por id: " + id);
        }
        recursoRepository.deleteById(id);
    }

    @Override
    public List<Recurso> buscarPorUsuario(Long idUsuario) {
        return recursoRepository.findByUsuario_idUsuario(idUsuario);
    }

    @Override
    public List<Recurso> buscraPorCategoria(Long idCategoria) {
        return recursoRepository.findByCategoria_idCategoria(idCategoria);
    }

    @Override
    public List<Recurso> buscarPorTipo(TipoRecurso tipoRecurso) {
        return recursoRepository.findByTipoRecurso(tipoRecurso);
    }
}
