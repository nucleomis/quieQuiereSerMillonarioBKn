package com.example.qqsm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "pregunta", indexes = {
        @Index(name = "fk_pregunta_juego1_idx", columnList = "juego_idjuego")
})
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpregunta", nullable = false)
    private Integer id;

    @Column(name = "pregunta", nullable = false, length = 45)
    private String pregunta;

    @Column(name = "dificultad", nullable = false)
    private Integer dificultad;

    @Column(name = "preguntacol", nullable = false, length = 45)
    private String preguntacol;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "juego_idjuego", nullable = false)
    private Juego juegoIdjuego;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Integer getDificultad() {
        return dificultad;
    }

    public void setDificultad(Integer dificultad) {
        this.dificultad = dificultad;
    }

    public String getPreguntacol() {
        return preguntacol;
    }

    public void setPreguntacol(String preguntacol) {
        this.preguntacol = preguntacol;
    }

    public Juego getJuegoIdjuego() {
        return juegoIdjuego;
    }

    public void setJuegoIdjuego(Juego juegoIdjuego) {
        this.juegoIdjuego = juegoIdjuego;
    }

}