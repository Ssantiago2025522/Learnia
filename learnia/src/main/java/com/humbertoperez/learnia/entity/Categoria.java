package com.humbertoperez.Learnia.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "categoria")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;

    @NotBlank(message = "No puede ir vacio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 60 caracteres")
    @Column(name = "nombre")
    private String nombreCategoria;


    @Column(name = "descripcion")
    @Min(value = 5, message = "Debe ser mayor a 5")
    @Max(value = 200, message = "Maximo de 200 caracteres")
    private String descripcionCategoria;

}
