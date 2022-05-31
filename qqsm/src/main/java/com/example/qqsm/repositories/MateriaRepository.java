package com.example.qqsm.repositories;

import com.example.qqsm.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepository extends CrudRepository<Materia, Integer> {

    Materia findByNombreMateria(String nome);
}