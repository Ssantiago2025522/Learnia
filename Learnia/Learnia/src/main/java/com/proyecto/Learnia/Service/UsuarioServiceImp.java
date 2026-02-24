package com.proyecto.Learnia.Service;

import com.proyecto.Learnia.Entity.Usuario;
import com.proyecto.Learnia.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImp implements UsuarioService {
    private final UsuarioRepository  usuarioRepository;
    private final UsuarioService usuarioService;

    public UsuarioServiceImp(UsuarioRepository usuarioRepository, UsuarioService usuarioService) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioService = usuarioService;
    }

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario crear(Usuario usuario) {
        usuario.setIdUsuario(null);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizar(Integer id, Usuario usuario) {
        return null;
    }

    @Override
    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById();
    }

    @Override
    public void eliminar(Integer id) {

    }
}
