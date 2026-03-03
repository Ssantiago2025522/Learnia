package com.humbertoperez.Learnia.Entity;

public enum RolUsuario {

    ADMIN("admin"),
    MODERADOR("moderador"),
    ESTUDIANTE("estudiante");

    private final String rol;

    RolUsuario(String rol) {
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public static RolUsuario fromRol(String rol) {
        for (RolUsuario r : RolUsuario.values()) {
            if (r.rol.equals(rol)) {
                return r;
            }
        }
        throw new IllegalArgumentException("Rol invalido: " + rol);
    }
}
