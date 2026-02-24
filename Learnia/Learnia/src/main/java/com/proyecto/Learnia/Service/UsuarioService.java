package com.proyecto.Learnia.Service;

import com.proyecto.Learnia.Dto.LoginDTO;
import com.proyecto.Learnia.Entity.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> listar();
    Usuario crear(Usuario usuario);
    Usuario actualizar(Integer id, Usuario usuario);
    Usuario buscarPorId(Integer id);
    void eliminar(Integer id);
    String login(LoginDTO loginDTO);
}
