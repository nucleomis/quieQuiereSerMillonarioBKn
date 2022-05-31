package com.example.qqsm.dto;

import com.example.qqsm.model.Pregunta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class JuegoIniciadoDto implements Serializable {
    private Integer id;
    private String nombreJuego;
    private LocalDate fechaCreacion;
    private List<PreguntaDto> preguntas;
}
