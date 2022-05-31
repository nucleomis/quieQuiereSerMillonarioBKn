package com.example.qqsm.controller;


import com.example.qqsm.service.PreguntaService;
import com.example.qqsm.utils.Constantes;
import com.example.qqsm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pregunta")
public class PreguntasController {

    @Autowired private PreguntaService preguntaService;

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listaPreguntas() {
        return new ResponseEntity<Response>(
            new Response(Constantes.Mensaje_01, preguntaService.getAllPreguntas()), HttpStatus.OK);
    }
}
