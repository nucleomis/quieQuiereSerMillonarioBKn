package com.example.qqsm.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RespuestaDto implements Serializable {
    private String respuesta;
    private Integer correcto;
}
