package com.proyecto.Learnia.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "categoria")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    @NotBlank(message = "El nombre no puede ir vacio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre {min} y {max} caracteres")
    @Column(name = "nombre")
    private String nombreCategoria;

    @NotBlank(message = "La descripcion no puede ir vacia")
    @Column(name = "descripcion", length = 255, nullable = false)
    @Size(max = 255, message = "La descripción no puede exceder los 255 caracteres")
    private String descripcionCategoria;
}
