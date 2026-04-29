package com.proyecto.Learnia.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "categoria")

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

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public @NotBlank(message = "El nombre no puede ir vacio") @Size(min = 3, max = 100, message = "El nombre debe tener entre {min} y {max} caracteres") String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(@NotBlank(message = "El nombre no puede ir vacio") @Size(min = 3, max = 100, message = "El nombre debe tener entre {min} y {max} caracteres") String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public @NotBlank(message = "La descripcion no puede ir vacia") @Size(max = 255, message = "La descripción no puede exceder los 255 caracteres") String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(@NotBlank(message = "La descripcion no puede ir vacia") @Size(max = 255, message = "La descripción no puede exceder los 255 caracteres") String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }
}
