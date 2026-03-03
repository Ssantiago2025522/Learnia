package com.proyecto.Learnia.service;

import com.proyecto.Learnia.entity.Categoria;
import com.proyecto.Learnia.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaServiceImp implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria crear(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria buscarPorId(Integer id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public Categoria actualizar(Integer id, Categoria categoria) {
        Categoria existente = categoriaRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombreCategoria(categoria.getNombreCategoria());
            existente.setDescripcionCategoria(categoria.getDescripcionCategoria());
            return categoriaRepository.save(existente);
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        categoriaRepository.deleteById(id);
    }
}