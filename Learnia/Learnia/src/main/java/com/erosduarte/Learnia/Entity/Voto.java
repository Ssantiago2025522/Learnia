package com.erosduarte.Learnia.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voto")
    private Long idVoto;

    @NotNull(message = "El tipo de voto es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoVoto tipo;

    @NotNull(message = "El usuario es obligatorio")
    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @NotNull(message = "La respuesta es obligatoria")
    @Column(name = "id_respuesta", nullable = false)
    private Long idRespuesta;

    public enum TipoVoto {
        like,
        dislike
    }

    // Getters y Setters
    public Long getIdVoto() { return idVoto; }
    public void setIdVoto(Long idVoto) { this.idVoto = idVoto; }

    public TipoVoto getTipo() { return tipo; }
    public void setTipo(TipoVoto tipo) { this.tipo = tipo; }

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public Long getIdRespuesta() { return idRespuesta; }
    public void setIdRespuesta(Long idRespuesta) { this.idRespuesta = idRespuesta; }
}
