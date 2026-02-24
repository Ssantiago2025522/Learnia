package com.proyecto.Learnia.Repository;

import com.proyecto.Learnia.Entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
