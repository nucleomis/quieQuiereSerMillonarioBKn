package com.example.qqsm.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MateriaHasProfesorId implements Serializable {
    private static final long serialVersionUID = 6853771341683268108L;
    @Column(name = "materia_idmateria", nullable = false)
    private Integer materiaIdmateria;

    @Column(name = "profesor_idprofesor", nullable = false)
    private Integer profesorIdprofesor;

    public Integer getMateriaIdmateria() {
        return materiaIdmateria;
    }

    public void setMateriaIdmateria(Integer materiaIdmateria) {
        this.materiaIdmateria = materiaIdmateria;
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
        MateriaHasProfesorId entity = (MateriaHasProfesorId) o;
        return Objects.equals(this.materiaIdmateria, entity.materiaIdmateria) &&
                Objects.equals(this.profesorIdprofesor, entity.profesorIdprofesor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(materiaIdmateria, profesorIdprofesor);
    }

}