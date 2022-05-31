package com.example.qqsm.dto;

import com.example.qqsm.model.Pregunta;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class JuegoClassDto implements Serializable {

    private Integer idProfesor;
    private String nombreJuego;
    private List<PreguntaDto> preguntas;
}
