package com.proyecto.Learnia.Service;

import com.proyecto.Learnia.Entity.Categoria;
import java.util.List;

public interface CategoriaService {
    List<Categoria> listar();
    Categoria crear(Categoria categoria);
    Categoria actualizar(Integer id, Categoria categoria);
    Categoria buscarPorId(Integer id);
    void eliminar(Integer id);
}