package com.example.qqsm.dto;

import com.example.qqsm.model.Pista;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
public class PreguntaDto implements Serializable {
    private Integer id;
    private String pregunta;
    private Integer dificultad;
    private List<RespuestaDto> respuestas;

    private List<PistaDto> pistas;


    public PreguntaDto(String pregunta, Integer dificultad, List<RespuestaDto> respuestas, List<Pista> pistas) {
        this.pregunta = pregunta;
        this.dificultad = dificultad;
        this.respuestas = respuestas;
    }
}
