package com.proyecto.Learnia.Service;

import com.proyecto.Learnia.Entity.Usuario;
import com.proyecto.Learnia.Exception.ResourceNotFoundException;
import com.proyecto.Learnia.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImp implements UsuarioService {
    private final UsuarioRepository  usuarioRepository;

    public UsuarioServiceImp(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
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
    public Usuario actualizar(Long id, Usuario usuario) {
        Usuario existente = buscarPorId(id);
        existente.setNombreUsuario(usuario.getNombreUsuario());
        existente.setContrasenaUsuario(usuario.getContrasenaUsuario());
        existente.setCorreoUsuario(usuario.getCorreoUsuario());
        existente.setFechaRegistro(usuario.getFechaRegistro());
        existente.setRolUsuario(usuario.getRolUsuario());
        existente.setFotoUsuario(usuario.getFotoUsuario());
        return  usuarioRepository.save(existente);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Usuario con id no encontrado: " + id));
    }

    @Override
    public void eliminar(Long id) {
        if(!usuarioRepository.existsById(id)){
            throw new ResourceNotFoundException(("Usuario con id no existente o no encontrado: " + id));
        }
         usuarioRepository.deleteById(id);
    }


}
