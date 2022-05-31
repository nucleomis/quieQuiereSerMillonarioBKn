package com.example.qqsm.model;

import javax.persistence.*;

@Entity
@Table(name = "pista", indexes = {
        @Index(name = "fk_pista_pregunta1_idx", columnList = "pregunta_idpregunta")
})
public class Pista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPregunta")
    private Integer id;

    @Column(name = "pista", nullable = false, length = 100)
    private String pista;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pregunta_idpregunta", nullable = false)
    private Pregunta preguntaIdpregunta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPista() {
        return pista;
    }

    public void setPista(String pista) {
        this.pista = pista;
    }

    public Pregunta getPreguntaIdpregunta() {
        return preguntaIdpregunta;
    }

    public void setPreguntaIdpregunta(Pregunta preguntaIdpregunta) {
        this.preguntaIdpregunta = preguntaIdpregunta;
    }

}