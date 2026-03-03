package com.proyecto.Learnia.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

    @Email
    @NotBlank
    public String correoUsuario;

    @NotBlank
    public String contrasenaUsuario;
}
