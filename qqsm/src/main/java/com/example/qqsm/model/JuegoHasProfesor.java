package com.example.qqsm.model;

import javax.persistence.*;

@Entity
@Table(name = "juego_has_profesor", indexes = {
        @Index(name = "fk_juego_has_profesor_juego1_idx", columnList = "juego_idjuego"),
        @Index(name = "fk_juego_has_profesor_profesor1_idx", columnList = "profesor_idprofesor")
})
public class JuegoHasProfesor {
    @EmbeddedId
    private JuegoHasProfesorId id;

    @MapsId("juegoIdjuego")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "juego_idjuego", nullable = false)
    private Juego juegoIdjuego;

    @MapsId("profesorIdprofesor")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "profesor_idprofesor", nullable = false)
    private Profesor profesorIdprofesor;

    public JuegoHasProfesorId getId() {
        return id;
    }

    public void setId(JuegoHasProfesorId id) {
        this.id = id;
    }

    public Juego getJuegoIdjuego() {
        return juegoIdjuego;
    }

    public void setJuegoIdjuego(Juego juegoIdjuego) {
        this.juegoIdjuego = juegoIdjuego;
    }

    public Profesor getProfesorIdprofesor() {
        return profesorIdprofesor;
    }

    public void setProfesorIdprofesor(Profesor profesorIdprofesor) {
        this.profesorIdprofesor = profesorIdprofesor;
    }

}