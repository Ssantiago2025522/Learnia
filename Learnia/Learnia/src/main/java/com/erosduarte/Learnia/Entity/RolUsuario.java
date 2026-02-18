package com.erosduarte.Learnia.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.management.StringValueExp;

public enum RolUsuario {
    ADMIN,
    MODERADOR,
    ESTUDIANTE;

    @JsonCreator
    public static RolUsuario from(String value){
        return RolUsuario.valueOf(value.toUpperCase());
    }

}
