package com.proyecto.Learnia.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class RegisterRequest {

    @NotBlank(message = "El nombre no puede ir vacio")
    public String nombreUsuario;

    @Email
    @NotBlank
    public String correoUsuario;

    @NotBlank(message = "La contraseña no puede estar vacia")
    public String contrasenaUsuario;

}
