package com.example.qqsm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "juego", indexes = {
        @Index(name = "fk_juego_participante1_idx", columnList = "participante_idparticipante")
})
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idjuego")
    private Integer id;

    @Column(name = "nombre_juego", nullable = false, length = 45)
    private String nombreJuego;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participante_idparticipante")
    private Participante participanteIdparticipante;

    @JsonIgnore
    @OneToMany(mappedBy = "juegoIdjuego")
    private List<Pregunta> preguntas = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "juego_has_profesor",
            joinColumns = @JoinColumn(name = "juego_idjuego"),
            inverseJoinColumns = @JoinColumn(name = "profesor_idprofesor"))
    @JsonIgnore
    private List<Profesor> profesors = new ArrayList<>();

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

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public List<Profesor> getProfesors() {
        return profesors;
    }

    public void setProfesors(List<Profesor> profesors) {
        this.profesors = profesors;
    }

}