package com.erosduarte.Learnia.Service;

import java.util.List;
import com.erosduarte.Learnia.Entity.Respuesta;

public interface RespuestaService {

    List<Respuesta> listar();

    Respuesta guardar(Respuesta respuesta);

    Respuesta buscarPorId(Long id);

    Respuesta actualizar(Long id, Respuesta respuesta);

    void eliminar(Long id);
}