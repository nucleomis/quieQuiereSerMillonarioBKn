package com.example.qqsm.repositories;


import com.example.qqsm.model.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {


}
