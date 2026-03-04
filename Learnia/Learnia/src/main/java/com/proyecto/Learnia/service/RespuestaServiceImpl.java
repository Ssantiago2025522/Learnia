package com.proyecto.Learnia.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import com.proyecto.Learnia.entity.Respuesta;
import com.proyecto.Learnia.repository.RespuestaRepository;

@Slf4j
@Service
public class RespuestaServiceImpl implements RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Override
    public List<Respuesta> listar() {
        return respuestaRepository.findAll();
    }

    @Override
    public Respuesta guardar(Respuesta respuesta) {
        respuesta.setFechaRespuesta(LocalDateTime.now());
        return respuestaRepository.save(respuesta);
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
        existente.setIdPregunta(nuevaRespuesta.getIdPregunta());
        existente.setFechaRespuesta(nuevaRespuesta.getFechaRespuesta());
        existente.setIdUsuario(nuevaRespuesta.getIdUsuario());
        return respuestaRepository.save(existente);

    }

    @Override
    public void eliminar(Long id) {
        respuestaRepository.deleteById(id);
    }
}