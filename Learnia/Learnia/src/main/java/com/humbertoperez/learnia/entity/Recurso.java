package com.humbertoperez.learnia.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "recurso")
public class Recurso {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recurso")
    private Long idRecurso;

    @NotBlank(message = "El titulo no puede estar vacio")
    @Column(name = "titulo_recurso")
    private String tituloRecurso;

    @Column(name = "dscripcion_recurso")
    private String descripcionRecurso;

    @Setter
    @NotNull(message = "Debe de seleccionar el tipo de recurso")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_recurso")
    private TipoRecurso tipoRecurso;

    @NotNull(message = "Debe de seleccionar el archivo")
    @Lob
    @Column(name = "url_archivo")
    private byte[] urlArchivo;

    @Setter
    @Column(name = "fecha_subida")
    private LocalDateTime fechaSubida;


    // Relación entre Tablas

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;


    // Getters & Setters

    public void setIdRecurso(Long idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getTituloRecurso() {
        return tituloRecurso;
    }

    public void setTituloRecurso(String tituloRecurso) {
        this.tituloRecurso = tituloRecurso;
    }

    public String getDescripcionRecurso() {
        return descripcionRecurso;
    }

    public void setDescripcionRecurso(String descripcionRecurso) {
        this.descripcionRecurso = descripcionRecurso;
    }

    public TipoRecurso getTipoRecurso() {
        return tipoRecurso;
    }

    public byte[] getUrlArchivo() {
        return urlArchivo;
    }

    public void setUrlArchivo(byte[] urlArchivo) {
        this.urlArchivo = urlArchivo;
    }

    public LocalDateTime getFechaSubida() {
        return fechaSubida;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
