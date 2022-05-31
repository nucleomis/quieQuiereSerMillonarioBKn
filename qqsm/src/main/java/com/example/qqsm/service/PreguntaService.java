package com.example.qqsm.service;

import com.example.qqsm.model.Pregunta;
import com.example.qqsm.repositories.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PreguntaService {

    @Autowired private PreguntaRepository preguntaRepository;

    public List<Pregunta> getAllPreguntas(){
        return (List) preguntaRepository.findAll();
    }

    public Pregunta getPreguntaById(Integer id){
        return preguntaRepository.findById(id).get();
    }

    public void addPregunta(Pregunta pregunta){
        preguntaRepository.save(pregunta);
    }

    public void updatePregunta(Pregunta pregunta){
        preguntaRepository.save(pregunta);
    }

    public void deletePregunta(Integer id){
        preguntaRepository.deleteById(id);
    }

    public Pregunta savePregunta(Pregunta pregunta){
        return preguntaRepository.save(pregunta);
    }

    public List<Pregunta> getPreguntasByJuegoId(Integer id){
            List<Pregunta> cuestions = new ArrayList<>();
            List<Pregunta> preguntas = (List<Pregunta>) preguntaRepository.findAll();

            for (Pregunta pregunta : preguntas) {
                if (pregunta.getJuegoIdjuego().getId() == id) {
                    cuestions.add(pregunta);
                }
            }
            return cuestions;
        };
}
