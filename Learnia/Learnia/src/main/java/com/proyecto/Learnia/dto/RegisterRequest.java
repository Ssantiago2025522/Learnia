package com.proyecto.Learnia.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



public class RegisterRequest {

    @NotBlank(message = "El nombre no puede ir vacio")
    @Size(min = 2, max = 100, message = "Numero de caracteres invalido en el nombre")
    public String nombreUsuario;

    @Email(message = "Formato del correo invalido")
    @NotBlank(message = "El correo es obligatorio")
    @Size(min = 5, max = 100, message = "Numero de caracteres invalido en el correo" )
    public String correoUsuario;

    @NotBlank(message = "La contraseña no puede estar vacia")
    @Size(min = 8, max = 100, message = "Numero de caracteres invalido en la contraseña")
    public String contrasenaUsuario;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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
}
