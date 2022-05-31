package com.example.qqsm.service;

import com.example.qqsm.model.Pista;
import com.example.qqsm.repositories.PistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PistaService {

    @Autowired private PistaRepository pistaRepository;

    public List<Pista> getPistasByPreguntaIdpregunta(Integer preguntaIdpregunta) {

        List<Pista> pistas = pistaRepository.findAll();

        List<Pista> pistafiltrada = new ArrayList<>();

        for (Pista pis : pistas){
            if (pis.getPreguntaIdpregunta().getId() == preguntaIdpregunta){
                pistafiltrada.add(pis);
            }
        }
        return pistafiltrada;
    }
    public void save(Pista p) {
        pistaRepository.save(p);
    }

    public void delete(Pista p) {
        pistaRepository.delete(p);
    }
}
