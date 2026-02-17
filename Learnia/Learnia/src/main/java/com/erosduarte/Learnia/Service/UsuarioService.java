package com.erosduarte.Learnia.Service;

import com.erosduarte.Learnia.Entity.Usuario;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface UsuarioService {
    List<Usuario> listar();
    Usuario crear(Usuario usuario);
    Usuario actualizar(Integer id, Usuario usuario);
    Usuario buscarPorId(Integer id);
    void eliminar(Integer id);
}
