package com.proyecto.Learnia.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

    @Email
    @NotBlank
    public String correoUsuario;

    @NotBlank
    public String contrasenaUsuario;
}
