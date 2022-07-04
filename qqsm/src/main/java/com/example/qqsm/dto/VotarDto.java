package com.example.qqsm.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class VotarDto implements Serializable {
    private Integer id;
    private Integer tipoVotacion;
    private String valor1;
    private String valor2;
    private String valor3;
    private String valor4;
    private Integer punto1;
    private Integer punto2;
    private Integer punto3;
    private Integer punto4;

}
