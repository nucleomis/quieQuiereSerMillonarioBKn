package com.example.qqsm.service;


import com.example.qqsm.model.Juego;
import com.example.qqsm.model.Profesor;
import com.example.qqsm.repositories.JuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JuegoService {

    @Autowired
    private JuegoRepository juegoRepository;

    public JuegoService(JuegoRepository juegoRepository) {
        this.juegoRepository = juegoRepository;
    }

    public Juego save(Juego juego){
        juegoRepository.save(juego);
        return juego;
    }


    public Juego findById(Integer id){


        return juegoRepository.findById(Math.toIntExact(id)).orElse(null);
    }

    public void delete(Juego juego){
        juegoRepository.delete(juego);
    }

    public void deleteById(Long id)throws Exception{
        juegoRepository.deleteById(Math.toIntExact(id));
    }

    public List<Juego> findAll(){
        return (List<Juego>) juegoRepository.findAll();
    }

    public List<Juego> findByNombre(String nombre){
        return juegoRepository.findByNombreJuego(nombre);
    }

    public List<Juego> findByProfesor(Profesor profesor){

        Iterable<Juego> profesors = juegoRepository.findAll();
        List<Juego>juegos = new ArrayList<>();

        for (Juego juego: profesors) {
            if(juego.getProfesors().contains(profesor)){
                juegos.add(juego);
            }
        }

        return juegos;
    }

    public void update(Juego juego){
        juegoRepository.save(juego);
    }
}
