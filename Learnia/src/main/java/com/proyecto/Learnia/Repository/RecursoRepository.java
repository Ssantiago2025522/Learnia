package com.proyecto.Learnia.Repository;

import com.proyecto.Learnia.Entity.Recurso;
import com.proyecto.Learnia.Entity.TipoRecurso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecursoRepository extends JpaRepository<Recurso, Long> {

    List<Recurso> findByUsuario_idUsuario(Long idUsuario);
    List<Recurso> findByCategoria_idCategoria(Long idCategoria);
    List<Recurso> findByTipoRecurso(TipoRecurso tipoRecurso);
}
