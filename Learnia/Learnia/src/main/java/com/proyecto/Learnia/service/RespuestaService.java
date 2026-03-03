package com.proyecto.Learnia.service;

import java.util.List;
import com.proyecto.Learnia.entity.Respuesta;

public interface RespuestaService {
    List<Respuesta> listar();
    Respuesta guardar(Respuesta respuesta);
    Respuesta buscarPorId(Long id);
    Respuesta actualizar(Long id, Respuesta respuesta);
    void eliminar(Long id);
}