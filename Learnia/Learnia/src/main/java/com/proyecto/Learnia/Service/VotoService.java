package com.proyecto.Learnia.Service;

import com.proyecto.Learnia.Entity.Voto;

import java.util.List;

public interface VotoService {
    List<Voto> listar();
    Voto crear(Voto voto);
    Voto buscarPorId(Long id);
    Voto actualizar(Long id, Voto voto);
    void eliminar(Long id);
}