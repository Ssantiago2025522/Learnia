package com.proyecto.Learnia.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "recurso")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recurso")
    private Long idRecurso;

    @NotBlank(message = "El titulo no puede estar vacio")
    @Size(min = 2, max = 100, message = "El titulo debe tener entre 2 y 60 caracteres")
    @Column(name = "titulo_recurso")
    private String tituloRecurso;

    @Column(name = "descripcion_recurso")
    @Min(value = 5, message = "Debe ser mayor a 5")
    @Max(value = 200, message = "Maximo de 200 caracteres")
    private String descripcionRecurso;

    @NotNull(message = "Debe de seleccionar el tipo de recurso")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_recurso")
    private TipoRecurso tipoRecurso;

    @NotBlank(message = "Debe de seleccionar el archivo")
    @Column(name = "url_archivo")
    private String urlArchivo;

    @Column(name = "fecha_subida")
    private LocalDateTime fechaSubida;
}
