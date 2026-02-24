package com.proyecto.Learnia.Service;

import java.util.List;
import com.proyecto.Learnia.Entity.Respuesta;

public interface RespuestaService {

    List<Respuesta> listar();

    Respuesta guardar(Respuesta respuesta);

    Respuesta buscarPorId(Long id);

    Respuesta actualizar(Long id, Respuesta respuesta);

    void eliminar(Long id);
}