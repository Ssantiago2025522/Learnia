package com.proyecto.Learnia.Service;

import com.proyecto.Learnia.Entity.Comentario;
import com.proyecto.Learnia.Repository.ComentarioRepository;
import com.proyecto.Learnia.Exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServiceImp implements ComentarioService {

    private final ComentarioRepository comentarioRepository;

    public ComentarioServiceImp(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    @Override
    public List<Comentario> listar() {
        return comentarioRepository.findAll();
    }

    @Override
    public Comentario crear(Comentario comentario) {
        comentario.setIdComentario(null);
        return comentarioRepository.save(comentario);
    }

    @Override
    public Comentario buscarPorId(Long id) {
        return comentarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario no encontrado con ID: " + id));
    }

    @Override
    public Comentario actualizar(Long id, Comentario comentario) {
        Comentario existente = buscarPorId(id);

        existente.setContenido(comentario.getContenido());
        existente.setIdRecurso(comentario.getIdRecurso());
        existente.setIdRespuesta(comentario.getIdRespuesta());

        return comentarioRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        if (!comentarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Comentario no encontrado con ID: " + id);
        }
        comentarioRepository.deleteById(id);
    }
}
