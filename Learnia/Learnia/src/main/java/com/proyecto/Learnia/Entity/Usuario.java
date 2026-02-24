package com.proyecto.Learnia.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @NotBlank(message = "El nombre del usuario no puede estar vacio")
    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @NotBlank(message = "El apellido del usuario no puede estar vacio")
    @Column(name = "apellido_usuario")
    private String apellidoUsuario;

    @NotBlank(message = "El correo no puede estar vacio")
    @Column(name = "correo_usuario")
    private String correoUsuario;

    @NotBlank(message = "La contraseña no puede estar vacia")
    @Column(name = "contrasena")
    private String contrasenaUsuario;

    @NotBlank(message = "La fecha no puede estar vacia")
    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @NotBlank(message = "El rol no puede estar vacio")
    @Column(name = "rol")
    private String  rolUsuario;

    @NotBlank(message = "La foto no puede estar vacia")
    @Column(name = "foto")
    private String fotoUsurio;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
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

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public String getFotoUsurio() {
        return fotoUsurio;
    }

    public void setFotoUsurio(String fotoUsurio) {
        this.fotoUsurio = fotoUsurio;
    }
}
