package com.example.qqsm.model;

import javax.persistence.*;

@Entity
@Table(name = "materia")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmateria", nullable = true)
    private Integer id;

    @Column(name = "nombre_materia", nullable = false, length = 45)
    private String nombreMateria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

}