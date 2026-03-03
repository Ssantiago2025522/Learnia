package com.proyecto.Learnia.service;

import java.util.List;
import com.proyecto.Learnia.entity.Pregunta;

public interface PreguntaService {
    List<Pregunta> listar();
    Pregunta guardar(Pregunta pregunta);
    Pregunta buscarPorId(Long id);
    void eliminar(Long id);
    Pregunta actualizar(Long id, Pregunta pregunta);
}