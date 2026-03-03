package com.proyecto.Learnia.Service;

import com.proyecto.Learnia.Dto.LoginRequest;
import com.proyecto.Learnia.Dto.LoginResponse;
import com.proyecto.Learnia.Dto.RegisterRequest;
import com.proyecto.Learnia.Entity.RolUsuario;
import com.proyecto.Learnia.Entity.Usuario;
import com.proyecto.Learnia.Repository.UsuarioRepository;
import org.apache.catalina.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegisterRequest req){
        if(usuarioRepository.existsByCorreoUsuario(req.correoUsuario)){
            throw new IllegalArgumentException("El correo ya esta registrado");
        }
        String hash = passwordEncoder.encode(req.contrasenaUsuario);
        Usuario usuario = new Usuario(req.nombreUsuario, req.correoUsuario, hash);
        usuario.setRolUsuario(RolUsuario.ESTUDIANTE);
        usuarioRepository.save(usuario);
    }

    public LoginResponse login(LoginRequest req){
        Usuario usuario = usuarioRepository.findByCorreoUsuario(req.correoUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Las credenciales son incorrectas o no existen"));

        boolean ok = passwordEncoder.matches(req.contrasenaUsuario, usuario.getContrasenaUsuario());
        if(!ok) throw new IllegalArgumentException("Contraseña incorrecta");

        return new LoginResponse("Login correcto : ", usuario.getIdUsuario(), usuario.getNombreUsuario(), usuario.getCorreoUsuario()) ;
    }
}
