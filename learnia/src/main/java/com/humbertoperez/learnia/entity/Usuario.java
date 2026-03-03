package com.humbertoperez.Learnia.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @NotBlank(message = "El nombre no puede ir vacio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 60 caracteres")
    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @NotBlank(message = "El apellido no debe ir vacio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 60 caracteres")
    @Column(name = "apellido_usuario")
    private String apellidoUsuario;

    @NotBlank(message = "El correo no puede ir vacio")
    @Size(min = 2, max = 100, message = "El correo debe tener entre 2 y 20 caracteres")
    @Column(name = "correo_usuario")
    private String correoUsuario;

    @NotBlank(message = "La contraseña no puede ir vacia")
    @Min(value = 1, message = "Debe ser mayor a 1")
    @Max(value = 120, message = "La contrasena es de 12 caracteres.")
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

}
