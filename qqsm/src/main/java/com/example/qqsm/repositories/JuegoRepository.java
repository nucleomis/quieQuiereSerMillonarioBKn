package com.example.qqsm.repositories;

import com.example.qqsm.model.Juego;
import com.example.qqsm.model.Profesor;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JuegoRepository extends CrudRepository<Juego, Integer>, JpaSpecificationExecutor<Juego> {
    List<Juego> findByNombreJuego(String nombre);

    List<Juego> findByParticipanteIdparticipante(Profesor profesor);
}