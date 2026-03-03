package com.proyecto.Learnia.Service;

import com.proyecto.Learnia.Entity.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> listar();
    Usuario crear(Usuario usuario);
    Usuario actualizar(Long id, Usuario usuario);
    Usuario buscarPorId(Long id);
    void eliminar(Long id);
}
