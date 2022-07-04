package com.example.qqsm.controller;


import com.example.qqsm.dto.VotarDto;
import com.example.qqsm.model.Votar;
import com.example.qqsm.service.VotarService;
import com.example.qqsm.utils.Constantes;
import com.example.qqsm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/votar")
public class VotarController {


    @Autowired
    VotarService votarService;

    @PostMapping(value="/votar",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> Votar(@RequestBody VotarDto votarDto){

        Integer longitud = votarService.findAll().size();

        Votar vot1 = new Votar();

        if (longitud == 0) {
            votarService.save(votarDto);
            vot1 = votarService.findById(1);
        }
        else {
            Votar vot = votarService.findById(1);

            vot.setTipoVotacion(votarDto.getTipoVotacion());
            vot.setValor1(votarDto.getValor1());
            vot.setValor2(votarDto.getValor2());
            vot.setValor3(votarDto.getValor3());
            vot.setValor4(votarDto.getValor4());
            vot.setPunto1(votarDto.getPunto1());
            vot.setPunto2(votarDto.getPunto2());
            vot.setPunto3(votarDto.getPunto3());
            vot.setPunto4(votarDto.getPunto4());

            votarService.update(vot);

            vot1 = votarService.findById(1);
        }
        return new ResponseEntity<Response>(new Response(Constantes.Mensaje_01, vot1), HttpStatus.OK);
    }

    @GetMapping("/quevotar")
    public ResponseEntity<Response> QueVotar(){

        Votar vot = votarService.findById(1);

        if(vot == null){
            return new ResponseEntity<Response>(new Response(Constantes.Mensaje_02, "no hay datos"), HttpStatus.OK);
        }
        return new ResponseEntity<Response>(new Response(Constantes.Mensaje_01, vot), HttpStatus.OK);
    }
}
