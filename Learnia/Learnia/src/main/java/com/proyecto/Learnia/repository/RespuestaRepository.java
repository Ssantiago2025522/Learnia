package com.proyecto.Learnia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.Learnia.entity.Respuesta;

import java.util.List;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

    List<Respuesta> findByPregunta_IdPregunta(Long idPregunta);
}