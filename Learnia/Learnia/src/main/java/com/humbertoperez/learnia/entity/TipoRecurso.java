package com.humbertoperez.learnia.entity;

public enum TipoRecurso {

    DOCUMENTO("documento"),
    PRESENTACION("presentacion"),
    AUDIO("audio");

    private final String valor;

    TipoRecurso(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static TipoRecurso fromValor(String valor) {
        for(TipoRecurso t : TipoRecurso.values()){
            if (t.valor.equals(valor)){
                return t;
            }
        }
        throw new IllegalArgumentException("Tipo invalido" + valor);
    }
}
