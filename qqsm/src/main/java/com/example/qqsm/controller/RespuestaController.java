package com.example.qqsm.controller;


import com.example.qqsm.repositories.RespuestaRepository;
import com.example.qqsm.service.RespuestaService;
import com.example.qqsm.utils.Constantes;
import com.example.qqsm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/respuesta")
public class RespuestaController {

    @Autowired private RespuestaService respuestaService;

    @Autowired private RespuestaRepository respuestaRepository;

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listaRespuestas() {
        return new ResponseEntity<Response>(new Response(Constantes.Mensaje_01, respuestaService.getAllRespuestas()), HttpStatus.OK);
    }

    @GetMapping(value = "/listarRespuestasIdPregunta/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listaRespuestasPregunta(@PathVariable("id") int id) {
        return new ResponseEntity<Response>(new Response(Constantes.Mensaje_01, respuestaService.getRespuestasByPregunta(id)), HttpStatus.OK);
    }
}
