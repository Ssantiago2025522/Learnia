package com.proyecto.Learnia.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pregunta")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pregunta")
    private Long idPregunta;

    @Column(nullable = false, length = 200)
    @Size(min = 15, max = 200, message = "El título debe tener entre 15 y 200 caracteres")
    private String titulo;

    @Column(nullable = false, columnDefinition = "TEXT")
    @Size(min = 20, max = 200, message = "La descripción debe tener entre 20 y 200 caracteres")
    private String descripcion;

    @Column(name = "fecha_publicacion")
    private LocalDateTime fechaPublicacion;

    @Column(name = "id_categoria", nullable = false)
    private Long idCategoria;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

}