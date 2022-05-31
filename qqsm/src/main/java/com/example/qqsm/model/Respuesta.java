package com.example.qqsm.model;

import javax.persistence.*;

@Entity
@Table(name = "respuesta", indexes = {
        @Index(name = "fk_respuesta_pregunta_idx", columnList = "pregunta_idpregunta")
})
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrespuesta", nullable = false)
    private Integer id;

    @Column(name = "correcto", nullable = false)
    private Integer correcto;

    @Column(name = "respuesta", nullable = false, length = 45)
    private String respuesta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pregunta_idpregunta", nullable = false)
    private Pregunta preguntaIdpregunta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCorrecto() {
        return correcto;
    }

    public void setCorrecto(Integer correcto) {
        this.correcto = correcto;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Pregunta getPreguntaIdpregunta() {
        return preguntaIdpregunta;
    }

    public void setPreguntaIdpregunta(Pregunta preguntaIdpregunta) {
        this.preguntaIdpregunta = preguntaIdpregunta;
    }

}