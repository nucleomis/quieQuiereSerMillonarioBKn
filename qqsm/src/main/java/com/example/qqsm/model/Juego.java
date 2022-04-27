package com.example.qqsm.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "juego")
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idjuego", nullable = false)
    private Integer id;

    @Column(name = "nombre_juego", nullable = false, length = 45)
    private String nombreJuego;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "participante_idparticipante", nullable = false)
    private Participante participanteIdparticipante;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreJuego() {
        return nombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Participante getParticipanteIdparticipante() {
        return participanteIdparticipante;
    }

    public void setParticipanteIdparticipante(Participante participanteIdparticipante) {
        this.participanteIdparticipante = participanteIdparticipante;
    }

}