package com.erosduarte.Learnia.Service;

import java.util.List;

import com.erosduarte.Learnia.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erosduarte.Learnia.Entity.Pregunta;
import com.erosduarte.Learnia.Repository.PreguntaRepository;

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
        existente.setUsuario(pregunta.getUsuario());
        existente.setIdCategoria(pregunta.getIdCategoria());

        return preguntaRepository.save(existente);
    }
}