package com.erosduarte.Learnia.Service;

import com.erosduarte.Learnia.Entity.Comentario;

import java.util.List;

public interface ComentarioService {
    List<Comentario> listar();
    Comentario crear(Comentario comentario);
    Comentario buscarPorId(Long id);
    Comentario actualizar(Long id, Comentario comentario);
    void eliminar(Long id);
}
