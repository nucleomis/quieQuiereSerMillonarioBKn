package com.example.qqsm.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "votar")
public class Votar {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idVotar")
  private Integer id;

  @Column(name = "tipoVotacion")
  private Integer tipoVotacion;

  @Column(name = "valor1", length = 70)
  private String valor1;

  @Column(name = "valor2", length = 70)
  private String valor2;

  @Column(name = "valor3", length = 70)
  private String valor3;

  @Column(name = "valor4", length = 70)
  private String valor4;

  @Column(name = "punto1")
  private Integer punto1;

  @Column(name = "punto2")
    private Integer punto2;

  @Column(name = "punto3")
  private Integer punto3;

  @Column(name = "punto4")
    private Integer punto4;

    public Votar() {}

    public Votar(Integer tipoVotacion, String valor1, String valor2, String valor3, String valor4, Integer punto1, Integer punto2, Integer punto3, Integer punto4) {
        this.tipoVotacion = tipoVotacion;
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.valor3 = valor3;
        this.valor4 = valor4;
        this.punto1 = punto1;
        this.punto2 = punto2;
        this.punto3 = punto3;
        this.punto4 = punto4;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTipoVotacion() {
        return tipoVotacion;
    }

    public void setTipoVotacion(Integer tipoVotacion) {
        this.tipoVotacion = tipoVotacion;
    }

    public String getValor1() {
        return valor1;
    }

    public void setValor1(String valor1) {
        this.valor1 = valor1;
    }

    public String getValor2() {
        return valor2;
    }

    public void setValor2(String valor2) {
        this.valor2 = valor2;
    }

    public String getValor3() {
        return valor3;
    }

    public void setValor3(String valor3) {
        this.valor3 = valor3;
    }

    public String getValor4() {
        return valor4;
    }

    public void setValor4(String valor4) {
        this.valor4 = valor4;
    }

    public Integer getPunto1() {
        return punto1;
    }

    public void setPunto1(Integer punto1) {
        this.punto1 = punto1;
    }

    public Integer getPunto2() {
        return punto2;
    }

    public void setPunto2(Integer punto2) {
        this.punto2 = punto2;
    }

    public Integer getPunto3() {
        return punto3;
    }

    public void setPunto3(Integer punto3) {
        this.punto3 = punto3;
    }

    public Integer getPunto4() {
        return punto4;
    }

    public void setPunto4(Integer punto4) {
        this.punto4 = punto4;
    }
}




