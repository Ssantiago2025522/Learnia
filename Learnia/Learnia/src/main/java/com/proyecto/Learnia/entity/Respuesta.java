package com.proyecto.Learnia.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "respuesta")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_respuesta")
    private Long idRespuesta;

    @Column(nullable = false, length = 1000)
    @Size(min = 5, max = 1000, message = "El contenido debe tener entre 5 y 1000 caracteres")
    private String contenido;

    @Column(name = "fecha_respuesta")
    private LocalDateTime fechaRespuesta;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "id_pregunta", nullable = false)
    private Long idPregunta;

}