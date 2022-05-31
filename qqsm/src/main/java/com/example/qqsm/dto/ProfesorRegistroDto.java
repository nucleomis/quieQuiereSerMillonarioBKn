package com.example.qqsm.dto;

import com.example.qqsm.model.Materia;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProfesorRegistroDto implements Serializable {
    private final String nombre;
    private final String apellido;
    private final String direccion;
    private final String email;
    private final String user;
    private final String password;
    private final List<Materia> materias = null;
}
