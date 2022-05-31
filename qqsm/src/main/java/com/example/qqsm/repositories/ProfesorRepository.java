package com.example.qqsm.repositories;

import com.example.qqsm.model.Profesor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends CrudRepository<Profesor, Long> {

    Profesor getProfesorByUserAndPassword(String user, String password);

    Profesor getProfesorByUser(String user);

    Profesor getProfesorById(int id);

    void deleteById(Integer profesor);
}
