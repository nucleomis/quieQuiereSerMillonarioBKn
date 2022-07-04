package com.example.qqsm.service;


import com.example.qqsm.dto.VotarDto;
import com.example.qqsm.model.Votar;
import com.example.qqsm.repositories.VotarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotarService {

    @Autowired  VotarRepository votarRepository;

    public void save(VotarDto votarDto){
        Votar votar = new Votar();
        votar.setTipoVotacion(votarDto.getTipoVotacion());
        votar.setValor1(votarDto.getValor1());
        votar.setValor2(votarDto.getValor2());
        votar.setValor3(votarDto.getValor3());
        votar.setValor4(votarDto.getValor4());
        votarRepository.save(votar);
    }

    public void delete(Integer id){
        votarRepository.deleteById(id);
    }

    public void update(VotarDto votarDto){
        Votar votar = new Votar();
        votar.setTipoVotacion(votarDto.getTipoVotacion());
        votar.setValor1(votarDto.getValor1());
        votar.setValor2(votarDto.getValor2());
        votar.setValor3(votarDto.getValor3());
        votar.setValor4(votarDto.getValor4());
        votarRepository.save(votar);
    }

    public Votar findById(Integer id){
        return votarRepository.findById(id).get();
    }

    public List<Votar> findAll(){
        return votarRepository.findAll();
    }

    public void update(Votar votar){
        votarRepository.save(votar);
    }
}
