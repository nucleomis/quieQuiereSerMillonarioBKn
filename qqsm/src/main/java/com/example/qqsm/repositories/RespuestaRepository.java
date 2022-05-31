package com.example.qqsm.repositories;

import com.example.qqsm.model.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RespuestaRepository extends CrudRepository<Respuesta, Integer> {

    List<Respuesta> findByPreguntaIdpregunta(Integer id);

    List<Respuesta> findAllByPreguntaIdpregunta(Integer id);
}