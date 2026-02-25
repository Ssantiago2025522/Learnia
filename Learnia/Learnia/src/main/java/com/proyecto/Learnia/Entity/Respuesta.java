package com.proyecto.Learnia.Entity;

import jakarta.persistence.*;
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

    @Column(nullable = false)
    private String contenido;

    @Column(name = "fecha_respuesta")
    private LocalDateTime fechaRespuesta;

    @Column(name = "id_usuario", nullable = false)
    private Long IdUsuario;

    @Column(name = "id_pregunta", nullable = false)
    private Long Idpregunta;
}