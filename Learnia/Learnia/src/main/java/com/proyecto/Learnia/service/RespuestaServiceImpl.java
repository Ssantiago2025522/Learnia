package com.proyecto.Learnia.service;

import com.proyecto.Learnia.entity.Pregunta;
import com.proyecto.Learnia.entity.Respuesta;
import com.proyecto.Learnia.entity.Usuario;
import com.proyecto.Learnia.repository.PreguntaRepository;
import com.proyecto.Learnia.repository.RespuestaRepository;

import com.proyecto.Learnia.repository.UsuarioRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RespuestaServiceImpl implements RespuestaService {

    private final RespuestaRepository respuestaRepository;
    private final UsuarioRepository usuarioRepository;
    private final PreguntaRepository preguntaRepository;

    public RespuestaServiceImpl(
            RespuestaRepository respuestaRepository,
            UsuarioRepository usuarioRepository,
            PreguntaRepository preguntaRepository) {

        this.respuestaRepository = respuestaRepository;
        this.usuarioRepository = usuarioRepository;
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    public List<Respuesta> listar() {
        return respuestaRepository.findAll();
    }

    public Respuesta guardar(Long preguntaId, String contenido) {

        Pregunta pregunta = preguntaRepository.findById(preguntaId)
                .orElseThrow(() ->
                        new RuntimeException("Pregunta no encontrada")
                );

        Authentication auth = SecurityContextHolder
                .getContext()
                .getAuthentication();

        String correo = auth.getName();

        Usuario usuario = usuarioRepository.findByCorreoUsuario(correo)
                .orElseThrow(() ->
                        new RuntimeException("Usuario no encontrado")
                );

        Respuesta respuesta = new Respuesta();

        respuesta.setContenido(contenido);
        respuesta.setFechaRespuesta(LocalDateTime.now());
        respuesta.setPregunta(pregunta);
        respuesta.setUsuario(usuario);

        return respuestaRepository.save(respuesta);
    }

    @Override
    public Respuesta buscarPorId(Long id) {

        return respuestaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Respuesta no encontrada")
                );
    }

    @Override
    public Respuesta actualizar(Long id, Respuesta nuevaRespuesta) {

        Respuesta existente = buscarPorId(id);

        existente.setContenido(nuevaRespuesta.getContenido());

        return respuestaRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        respuestaRepository.deleteById(id);
    }
}
