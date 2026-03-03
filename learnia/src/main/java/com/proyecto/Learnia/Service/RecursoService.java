package com.proyecto.Learnia.Service;

import com.proyecto.Learnia.Entity.Recurso;
import com.proyecto.Learnia.Entity.TipoRecurso;

import java.util.List;

public interface RecursoService {

    List<Recurso> listar();
    Recurso crearReC(Recurso recurso);
    Recurso actualizarReC(Long id, Recurso recurso);
    Recurso buscarPorIdRec(Long id);
    void eliminar(Long id);

    List<Recurso> buscarPorUsuario(Long idUsuario);
    List<Recurso> buscraPorCategoria(Long idCategoria);
    List<Recurso> buscarPorTipo(TipoRecurso tipoRecurso);
}
