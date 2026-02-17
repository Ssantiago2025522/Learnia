package com.humbertoperez.learnia.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;

    @NotBlank(message = "No puede ir vacio")
    @Column(name = "nombre")
    private String nombreCategoria;

    @Column(name = "descripcion")
    private String descripcionCategoria;

    // Getters $ Setters


    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }
}
