package com.proyecto.Learnia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.Learnia.entity.Pregunta;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
}