package com.humbertoperez.learnia.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @NotBlank(message = "El nombre no puede ir vacio")
    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @NotBlank(message = "El apellido no debe ir vacio")
    @Column(name = "apellido_usuario")
    private String apellidoUsuario;

    @NotBlank(message = "El correo no puede ir vacio")
    @Column(name = "correo_usuario")
    private String correoUsuario;

    @NotBlank(message = "La contraseña no puede ir vacia")
    @Column(name = "contraseña")
    private String contrasena;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @NotNull(message = "Debe seleccionar el roll")
    @Enumerated(EnumType.STRING)
    @Column(name = "rol_usuario")
    private RolUsuario rolUsuario;

    @Column(name = "foto")
    private String fotoUsuario;

    // Getters $ Setters


    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public RolUsuario getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(RolUsuario rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public String getFotoUsuario() {
        return fotoUsuario;
    }

    public void setFotoUsuario(String fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }
}
