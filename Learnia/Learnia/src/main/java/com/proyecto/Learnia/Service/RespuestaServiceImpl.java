package com.proyecto.Learnia.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import com.proyecto.Learnia.Entity.Respuesta;
import com.proyecto.Learnia.Repository.RespuestaRepository;

@Service
public class RespuestaServiceImpl implements RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Override
    public List<Respuesta> listar() {
        return respuestaRepository.findAll();
    }

    @Override
    public Respuesta guardar(Long preguntaId, String contenido) {

        Pregunta pregunta = preguntaRepository.findById(preguntaId)
                .orElseThrow(() -> new RuntimeException(""));

        Usuario usuario = UsuarioRepository.findById(1L).orElseThrow();

        Respuesta r = new Respuesta();
        r.setContenido(contenido);
        r.setFechaRespuesta(LocalDateTime.now());
        r.setUsuario(usuario);
        r.setPregunta(pregunta);

        return respuestaRepository.save(r);
        }

    @Override
    public Respuesta buscarPorId(Long id) {
        return respuestaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Respuesta no encontrada"));
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