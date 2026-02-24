package com.proyecto.Learnia.Service;

import com.proyecto.Learnia.Entity.Comentario;

import java.util.List;

public interface ComentarioService {
    List<Comentario> listar();
    Comentario crear(Comentario comentario);
    Comentario buscarPorId(Long id);
    Comentario actualizar(Long id, Comentario comentario);
    void eliminar(Long id);
}
