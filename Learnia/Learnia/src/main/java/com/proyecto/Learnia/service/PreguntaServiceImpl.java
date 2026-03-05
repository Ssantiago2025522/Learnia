package com.proyecto.Learnia.service;

import java.time.LocalDateTime;
import java.util.List;

import com.proyecto.Learnia.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.Learnia.entity.Pregunta;
import com.proyecto.Learnia.repository.PreguntaRepository;

@Service
public class PreguntaServiceImpl implements PreguntaService {

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Override
    public List<Pregunta> listar() {
        return preguntaRepository.findAll();
    }

    @Override
    public Pregunta guardar(Pregunta pregunta) {
        pregunta.setFechaPublicacion(LocalDateTime.now());
        return preguntaRepository.save(pregunta);
    }

    @Override
    public Pregunta buscarPorId(Long id) {
        return preguntaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pregunta no encontrada con id: " + id));
    }

    @Override
    public void eliminar(Long id) {
        preguntaRepository.deleteById(id);
    }

    @Override
    public Pregunta actualizar(Long id, Pregunta pregunta) {

        Pregunta existente = preguntaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pregunta no encontrada con id: " + id));

        existente.setTitulo(pregunta.getTitulo());
        existente.setDescripcion(pregunta.getDescripcion());
        existente.setCategoria(pregunta.getCategoria());
        existente.setUsuario(pregunta.getUsuario());
        return preguntaRepository.save(existente);
    }
}