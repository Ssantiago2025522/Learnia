package com.proyecto.Learnia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.Learnia.entity.Pregunta;

import java.util.List;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
    List<Pregunta> findByCategoria_IdCategoria(Long idCategoria);
}