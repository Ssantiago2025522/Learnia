package com.proyecto.Learnia.service;

import com.proyecto.Learnia.dto.RecursoDTO;
import com.proyecto.Learnia.entity.Categoria;
import com.proyecto.Learnia.entity.Recurso;
import com.proyecto.Learnia.entity.TipoRecurso;
import com.proyecto.Learnia.entity.Usuario;
import com.proyecto.Learnia.exception.ResourceNotFoundException;
import com.proyecto.Learnia.repository.CategoriaRepository;
import com.proyecto.Learnia.repository.RecursoRepository;
import com.proyecto.Learnia.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecursoServiceImpl implements RecursoService{

    private final RecursoRepository recursoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CategoriaRepository categoriaRepository;

    public RecursoServiceImpl(RecursoRepository recursoRepository,
                             UsuarioRepository usuarioRepository,
                             CategoriaRepository categoriaRepository) {
        this.recursoRepository = recursoRepository;
        this.usuarioRepository = usuarioRepository;
        this.categoriaRepository = categoriaRepository;
    }
    @Override
    public List<Recurso> listar() {
        return recursoRepository.findAll();
    }

    @Override
    public Recurso crear(RecursoDTO recursoDTO) {
        Usuario usuario = usuarioRepository.findById(recursoDTO.getIdUsuario())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        Categoria categoria = categoriaRepository.findById(recursoDTO.getIdCategoria())
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada"));
        Recurso recurso = new Recurso();
        recurso.setTituloRecurso(recursoDTO.getTituloRecurso());
        recurso.setDescripcionRecurso(recursoDTO.getDescripcionRecurso());
        recurso.setTipoRecurso(recursoDTO.getTipoRecurso());
        recurso.setUrlArchivo(recursoDTO.getUrlArchivo());
        recurso.setFechaSubida(LocalDateTime.now());
        recurso.setUsuario(usuario);
        recurso.setCategoria(categoria);
        return recursoRepository.save(recurso);
    }

    @Override
    public Recurso buscarPorIdRec(Long id) {
        return recursoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso no encontrado por id: " + id));
    }

    @Override
    public Recurso actualizarReC(Long id, Recurso recurso) {
        Recurso existe = buscarPorIdRec(id);

        existe.setTituloRecurso(recurso.getTituloRecurso());
        existe.setDescripcionRecurso(recurso.getDescripcionRecurso());
        existe.setTipoRecurso(recurso.getTipoRecurso());
        existe.setUrlArchivo(recurso.getUrlArchivo());
        existe.setFechaSubida(recurso.getFechaSubida());
        existe.setCategoria(recurso.getCategoria());
        existe.setUsuario(recurso.getUsuario());
        return recursoRepository.save(existe);
    }

    @Override
    public void eliminar(Long id) {
        if (!recursoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso no encontrado por id: " + id);
        }
        recursoRepository.deleteById(id);
    }


}
