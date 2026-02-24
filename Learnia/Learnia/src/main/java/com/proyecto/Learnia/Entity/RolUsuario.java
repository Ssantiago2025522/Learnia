package com.proyecto.Learnia.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum RolUsuario {
    ADMIN,
    MODERADOR,
    ESTUDIANTE;

    @JsonCreator
    public static RolUsuario from(String value){
        return RolUsuario.valueOf(value.toUpperCase());
    }

}
