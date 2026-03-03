package com.proyecto.Learnia.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "voto")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
}

