package com.example.qqsm.model;

import javax.persistence.*;

@Entity
@Table(name = "participante")
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idparticipante", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "puntaje", length = 45)
    private String puntaje;

    @Column(name = "ya_jugo")
    private Integer yaJugo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }

    public Integer getYaJugo() {
        return yaJugo;
    }

    public void setYaJugo(Integer yaJugo) {
        this.yaJugo = yaJugo;
    }

}