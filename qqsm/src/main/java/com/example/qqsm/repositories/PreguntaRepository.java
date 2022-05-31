package com.example.qqsm.repositories;

import com.example.qqsm.model.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface PreguntaRepository extends CrudRepository<Pregunta, Integer> {

}