package com.example.qqsm.model;

import javax.persistence.*;

@Entity
@Table(name = "materia_has_profesor", indexes = {
        @Index(name = "fk_materia_has_profesor_materia1_idx", columnList = "materia_idmateria"),
        @Index(name = "fk_materia_has_profesor_profesor1_idx", columnList = "profesor_idprofesor")
})
public class MateriaHasProfesor {
    @EmbeddedId
    private MateriaHasProfesorId id;

    @MapsId("materiaIdmateria")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "materia_idmateria", nullable = false)
    private Materia materiaIdmateria;

    @MapsId("profesorIdprofesor")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "profesor_idprofesor", nullable = false)
    private Profesor profesorIdprofesor;

    public MateriaHasProfesorId getId() {
        return id;
    }

    public void setId(MateriaHasProfesorId id) {
        this.id = id;
    }

    public Materia getMateriaIdmateria() {
        return materiaIdmateria;
    }

    public void setMateriaIdmateria(Materia materiaIdmateria) {
        this.materiaIdmateria = materiaIdmateria;
    }

    public Profesor getProfesorIdprofesor() {
        return profesorIdprofesor;
    }

    public void setProfesorIdprofesor(Profesor profesorIdprofesor) {
        this.profesorIdprofesor = profesorIdprofesor;
    }

}