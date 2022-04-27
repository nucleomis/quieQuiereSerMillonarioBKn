package com.example.qqsm.service;

import com.example.qqsm.model.Profesor;
import com.example.qqsm.repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    public void addProfesor(String nombre, String apellido, String correo, String user, String contrasena) {
        profesorRepository.save(new Profesor(nombre, apellido, correo,user,contrasena));
    }

    public Profesor getProfesorByUserAndPassword(String user, String contrasena) {
        return profesorRepository.getProfesorByUserAndPassword(user, contrasena);
    }

    public Profesor getProfesorByUser(String user) {
        return profesorRepository.getProfesorByUser(user);
    }


    public Profesor getProfesorById(int id) {
        return profesorRepository.getProfesorById(id);
    }

    public void updateProfesor(Profesor profesor) {
        profesorRepository.save(profesor);
    }

    public void deleteProfesor(Profesor profesor) {
        profesorRepository.delete(profesor);
    }

    public List<Profesor> getProfesors()
    {
        return (List<Profesor>) profesorRepository.findAll();
    }

}


