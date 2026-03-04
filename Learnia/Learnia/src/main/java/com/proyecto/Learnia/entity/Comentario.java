package com.proyecto.Learnia.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comentario")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private Long idComentario;

    @NotBlank(message = "El contenido no puede estar vacío")
    @Size(min = 1,max = 500, message = "El comentario tiene que tener entre 1 y 500 caracteres")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String contenido;

    @Column(nullable = false)
    private LocalDateTime fecha = LocalDateTime.now();

    @NotNull(message = "El usuario es obligatorio")
    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "id_recurso")
    private Long idRecurso;

    @Column(name = "id_respuesta")
    private Long idRespuesta;

}
