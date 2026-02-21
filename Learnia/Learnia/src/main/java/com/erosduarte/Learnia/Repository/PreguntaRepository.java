package com.erosduarte.Learnia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.erosduarte.Learnia.Entity.Pregunta;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
}