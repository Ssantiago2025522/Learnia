package com.proyecto.Learnia.service;

import com.proyecto.Learnia.dto.RespuestaDTO;
import com.proyecto.Learnia.entity.Pregunta;
import com.proyecto.Learnia.entity.Respuesta;
import com.proyecto.Learnia.entity.Usuario;
import com.proyecto.Learnia.exception.ResourceNotFoundException;
import com.proyecto.Learnia.repository.PreguntaRepository;
import com.proyecto.Learnia.repository.RespuestaRepository;
import com.proyecto.Learnia.repository.UsuarioRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RespuestaServiceImpl implements RespuestaService {

    private final RespuestaRepository respuestaRepository;
    private final UsuarioRepository usuarioRepository;
    private final PreguntaRepository preguntaRepository;

    public RespuestaServiceImpl(RespuestaRepository respuestaRepository,
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

    @Override
    public Respuesta crear(RespuestaDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + dto.getIdUsuario()));

        Pregunta pregunta = preguntaRepository.findById(dto.getIdPregunta())
                .orElseThrow(() -> new ResourceNotFoundException("Pregunta no encontrada con ID: " + dto.getIdPregunta()));

        Respuesta respuesta = new Respuesta();
        respuesta.setContenido(dto.getContenido());
        respuesta.setUsuario(usuario);
        respuesta.setPregunta(pregunta);
        respuesta.setFechaRespuesta(LocalDateTime.now());

        return respuestaRepository.save(respuesta);
    }

    @Override
    public Respuesta buscarPorId(Long id) {
        return respuestaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Respuesta no encontrada con ID: " + id));
    }

    @Override
    public Respuesta actualizar(Long id, RespuestaDTO dto) {
        Respuesta existente = buscarPorId(id);
        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        Pregunta pregunta = preguntaRepository.findById(dto.getIdPregunta())
                .orElseThrow(() -> new ResourceNotFoundException("Pregunta no encontrada"));
        existente.setContenido(dto.getContenido());
        existente.setUsuario(usuario);
        existente.setPregunta(pregunta);
        existente.setFechaRespuesta(LocalDateTime.now());

        return respuestaRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        if (!respuestaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Respuesta no encontrada con ID: " + id);
        }
        respuestaRepository.deleteById(id);
        System.out.println("Respuesta con ID " + id + " eliminada correctamente");
    }
}