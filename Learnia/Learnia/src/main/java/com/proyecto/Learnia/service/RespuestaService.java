package com.proyecto.Learnia.service;

import java.util.List;

import com.proyecto.Learnia.dto.RespuestaDTO;
import com.proyecto.Learnia.entity.Respuesta;

public interface RespuestaService {
    List<Respuesta> listar();
    Respuesta crear(RespuestaDTO dto);
    Respuesta buscarPorId(Long id);
    Respuesta actualizar(Long id, RespuestaDTO dto);
    void eliminar(Long id);
}