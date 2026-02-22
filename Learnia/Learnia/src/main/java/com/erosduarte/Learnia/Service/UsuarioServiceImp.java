package com.erosduarte.Learnia.Service;

import com.erosduarte.Learnia.Dto.LoginDTO;
import com.erosduarte.Learnia.Entity.Usuario;
import com.erosduarte.Learnia.Exception.ResourceNotFoundException;
import com.erosduarte.Learnia.Repository.UsuarioRepository;
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
    public Usuario actualizar(Integer id, Usuario usuario) {
        Usuario existente = buscarPorId(id);
        existente.setNombreUsuario(usuario.getNombreUsuario());
        existente.setApellidoUsuario(usuario.getApellidoUsuario());
        existente.setContrasenaUsuario(usuario.getContrasenaUsuario());
        existente.setCorreoUsuario(usuario.getCorreoUsuario());
        existente.setFechaRegistro(usuario.getFechaRegistro());
        existente.setRolUsuario(usuario.getRolUsuario());
        existente.setFotoUsuario(usuario.getFotoUsuario());
        return  usuarioRepository.save(existente);
    }

    @Override
    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Usuario con id no encontrado: " + id));
    }

    @Override
    public void eliminar(Integer id) {
        if(!usuarioRepository.existsById(id)){
            throw new ResourceNotFoundException(("Usuario con id no existente o no encontrado: " + id));
        }
         usuarioRepository.deleteById(id);
    }

    @Override
    public String login(LoginDTO loginDTO) {
        Optional<Usuario> usuario = usuarioRepository.findByCorreoUsuario(loginDTO.getCorreoUsuario());

        if(usuario.isPresent()){
            if(usuario.get().getContrasenaUsuario().equals(loginDTO.getContrasenaUsuario())){
                return "Login exitoso";
            }else{
                return "Contraseña incorrecta";
            }
        }else{
            return "Usuario no encontrado";
        }
    }
}
