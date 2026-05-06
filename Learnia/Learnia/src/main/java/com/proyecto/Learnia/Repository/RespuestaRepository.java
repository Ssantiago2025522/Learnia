package com.proyecto.Learnia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.Learnia.Entity.Respuesta;

import java.util.List;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

    List<Respuesta> findByPregunta_IdPregunta(Long idPregunta);
}