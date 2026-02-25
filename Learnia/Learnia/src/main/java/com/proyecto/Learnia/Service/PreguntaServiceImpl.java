package com.proyecto.Learnia.Service;

import java.util.List;

import com.proyecto.Learnia.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.Learnia.Entity.Pregunta;
import com.proyecto.Learnia.Repository.PreguntaRepository;

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
        existente.setIdCategoria(pregunta.getIdCategoria());
        existente.setIdUsuario(pregunta.getIdUsuario());
        return preguntaRepository.save(existente);
    }
}