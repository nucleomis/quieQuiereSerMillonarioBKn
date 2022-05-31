package com.example.qqsm.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JuegoHasProfesorId implements Serializable {
    private static final long serialVersionUID = -9216780193924960291L;
    @Column(name = "juego_idjuego", nullable = false)
    private Integer juegoIdjuego;

    @Column(name = "profesor_idprofesor", nullable = false)
    private Integer profesorIdprofesor;

    public Integer getJuegoIdjuego() {
        return juegoIdjuego;
    }

    public void setJuegoIdjuego(Integer juegoIdjuego) {
        this.juegoIdjuego = juegoIdjuego;
    }

    public Integer getProfesorIdprofesor() {
        return profesorIdprofesor;
    }

    public void setProfesorIdprofesor(Integer profesorIdprofesor) {
        this.profesorIdprofesor = profesorIdprofesor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        JuegoHasProfesorId entity = (JuegoHasProfesorId) o;
        return Objects.equals(this.profesorIdprofesor, entity.profesorIdprofesor) &&
                Objects.equals(this.juegoIdjuego, entity.juegoIdjuego);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profesorIdprofesor, juegoIdjuego);
    }

}