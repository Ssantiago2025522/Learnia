package com.proyecto.Learnia.service;

import com.proyecto.Learnia.dto.PreguntaDTO;
import com.proyecto.Learnia.entity.Pregunta;
import com.proyecto.Learnia.entity.Usuario;
import com.proyecto.Learnia.entity.Categoria;
import com.proyecto.Learnia.exception.ResourceNotFoundException;
import com.proyecto.Learnia.repository.PreguntaRepository;
import com.proyecto.Learnia.repository.UsuarioRepository;
import com.proyecto.Learnia.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PreguntaServiceImpl implements PreguntaService {

    private final PreguntaRepository preguntaRepository;
    private final UsuarioRepository usuarioRepository;
    private final CategoriaRepository categoriaRepository;

    public PreguntaServiceImpl(PreguntaRepository preguntaRepository,
                               UsuarioRepository usuarioRepository,
                               CategoriaRepository categoriaRepository) {
        this.preguntaRepository = preguntaRepository;
        this.usuarioRepository = usuarioRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Pregunta> listar() {
        return preguntaRepository.findAll();
    }

    @Override
    public Pregunta buscarPorId(Long id) {
        return preguntaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pregunta no encontrada con ID: " + id));
    }

    @Override
    public Pregunta guardar(PreguntaDTO dto) {
        Pregunta pregunta = new Pregunta();
        pregunta.setFechaPublicacion(LocalDateTime.now());
        return mapearYGuardar(pregunta, dto);
    }

    @Override
    public Pregunta actualizar(Long id, PreguntaDTO dto) {
        Pregunta existente = buscarPorId(id);
        return mapearYGuardar(existente, dto);
    }

    @Override
    public void eliminar(Long id) {
        if (!preguntaRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se puede eliminar, ID no encontrado: " + id);
        }
        preguntaRepository.deleteById(id);
    }

    private Pregunta mapearYGuardar(Pregunta entidad, PreguntaDTO dto) {
        entidad.setTitulo(dto.getTitulo());
        entidad.setDescripcion(dto.getDescripcion());

        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        Categoria categoria = categoriaRepository.findById(dto.getIdCategoria())
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada"));

        entidad.setUsuario(usuario);
        entidad.setCategoria(categoria);

        return preguntaRepository.save(entidad);
    }
}