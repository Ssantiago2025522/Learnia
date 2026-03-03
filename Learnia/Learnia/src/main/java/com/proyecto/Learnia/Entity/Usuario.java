package com.proyecto.Learnia.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "usuario", uniqueConstraints = {
        @UniqueConstraint(columnNames = "correoUsuario")
})
@Getter
@Setter
@ToString
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @NotBlank(message = "El nombre del usuario no puede estar vacio")
    @Column(name = "username")
    private String nombreUsuario;


    @NotBlank(message = "El correo no puede estar vacio")
    @Column(name = "correo_usuario", unique = true)
    private String correoUsuario;

    @NotBlank(message = "La contraseña no puede estar vacia")
    @Column(name = "contrasena")
    private String contrasenaUsuario;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;


    @Enumerated(EnumType.STRING)
    @Column(name = "rol")
    private RolUsuario  rolUsuario;

    @Column(name = "foto")
    private String fotoUsuario;


    public Usuario(String nombreUsuario, String correoUsuario, String contrasenaUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.correoUsuario = correoUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public  Usuario(){

    }




}
