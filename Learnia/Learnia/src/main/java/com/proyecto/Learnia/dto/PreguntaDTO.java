package com.proyecto.Learnia.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PreguntaDTO {
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaPublicacion;
    private Long idUsuario;
    private Long idCategoria;
}