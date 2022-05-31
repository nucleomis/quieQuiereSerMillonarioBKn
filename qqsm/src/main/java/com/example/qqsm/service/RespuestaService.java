package com.example.qqsm.service;


import com.example.qqsm.model.Respuesta;
import com.example.qqsm.repositories.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespuestaService {

    @Autowired private RespuestaRepository respuestaRepository;

    public List<Respuesta> getAllRespuestas(){
        return (List<Respuesta>) respuestaRepository.findAll();
    }

    public Respuesta getRespuestaById(Integer id){
        return respuestaRepository.findById(id).get();
    }

    public List<Respuesta> getRespuestasByPreguntaId(Integer id){
        return respuestaRepository.findAllByPreguntaIdpregunta(id);
    }

    public void addRespuesta(Respuesta respuesta){
        respuestaRepository.save(respuesta);
    }

    public void updateRespuesta(Respuesta respuesta){
        respuestaRepository.save(respuesta);
    }

    public void deleteRespuesta(Integer id){
        respuestaRepository.deleteById(id);
    }

    public Respuesta saveRespuesta(Respuesta respuesta){
        return respuestaRepository.save(respuesta);
    }

    public List<Respuesta> getRespuestasByPregunta(Integer id){

        List<Respuesta> respuestas = (List<Respuesta>) respuestaRepository.findAll();

        List<Respuesta> rs = respuestas.stream()
                .filter(r -> r.getPreguntaIdpregunta().getId().equals(id))
                .collect(java.util.stream.Collectors.toList());

        return rs;
    }

    public void delete(Respuesta respuesta) {
        respuestaRepository.delete(respuesta);
    }
}
