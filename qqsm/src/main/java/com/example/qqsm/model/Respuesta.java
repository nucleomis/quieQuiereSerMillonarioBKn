package com.example.qqsm.model;

import javax.persistence.*;

@Entity
@Table(name = "respuesta")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrespuesta", nullable = false)
    private Integer id;

    @Column(name = "respuesta", nullable = false, length = 45)
    private String respuesta;

    @Column(name = "correcto", nullable = false)
    private Integer correcto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pregunta_idpregunta", nullable = false)
    private Pregunta preguntaIdpregunta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Integer getCorrecto() {
        return correcto;
    }

    public void setCorrecto(Integer correcto) {
        this.correcto = correcto;
    }

    public Pregunta getPreguntaIdpregunta() {
        return preguntaIdpregunta;
    }

    public void setPreguntaIdpregunta(Pregunta preguntaIdpregunta) {
        this.preguntaIdpregunta = preguntaIdpregunta;
    }

}