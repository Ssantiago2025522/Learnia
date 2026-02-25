package com.proyecto.Learnia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.Learnia.Entity.Pregunta;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
}