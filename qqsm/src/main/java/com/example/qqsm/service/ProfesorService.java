package com.example.qqsm.service;

import com.example.qqsm.model.Juego;
import com.example.qqsm.model.Profesor;
import com.example.qqsm.repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    public void addProfesor(Profesor profesor) {
        profesorRepository.save(profesor);
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

    public void deleteProfesor(Integer profesor) {
        profesorRepository.deleteById(profesor);
    }

    public List<Profesor> getProfesors()
    {
        return (List<Profesor>) profesorRepository.findAll();
    }

    public void addJuego(Profesor profesor, List<Juego> juegos) {
    }

    public boolean existeUsuario(String nombre) {
        ArrayList<Profesor> usuarios = (ArrayList<Profesor>) profesorRepository.findAll();
        for (Profesor usuario : usuarios) {
            if (usuario.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public Profesor getUsuariosPorNombreYPass(String nombre, String pass) {

        ArrayList<Profesor> usuarios = (ArrayList<Profesor>) profesorRepository.findAll();

        Profesor user = null;
        for (Profesor usuario : usuarios) {
            if (usuario.getNombre().equals(nombre) && usuario.getPassword().equals(pass)) {
                user = usuario;
            }
        }
        return user;
    }
}


