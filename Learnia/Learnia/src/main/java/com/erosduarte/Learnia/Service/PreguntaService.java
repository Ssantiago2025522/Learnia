package com.erosduarte.Learnia.Service;

import java.util.List;
import com.erosduarte.Learnia.Entity.Pregunta;

public interface PreguntaService {
    List<Pregunta> listar();
    Pregunta guardar(Pregunta pregunta);
    Pregunta buscarPorId(Long id);
    void eliminar(Long id);
    Pregunta actualizar(Long id, Pregunta pregunta);
}