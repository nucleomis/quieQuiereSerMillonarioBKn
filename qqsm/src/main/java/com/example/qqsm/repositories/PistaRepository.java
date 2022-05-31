package com.example.qqsm.repositories;

import com.example.qqsm.model.Pista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PistaRepository extends JpaRepository<Pista, Integer> {

    List<Pista> findPistaByPreguntaIdpregunta(Integer preguntaIdpregunta);
}