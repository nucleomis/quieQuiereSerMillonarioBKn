package com.example.qqsm.controller;


import com.example.qqsm.dto.*;
import com.example.qqsm.model.*;
import com.example.qqsm.service.*;

import com.example.qqsm.utils.Constantes;
import com.example.qqsm.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/juego")
public class JuegoController {

  private static final Logger LOGGER = LoggerFactory.getLogger(JuegoController.class);

  @Autowired private JuegoService juegoService;

  @Autowired private PreguntaService preguntaService;

  @Autowired private RespuestaService respuestaService;

  @Autowired private PistaService pistaService;
  @Autowired
  ProfesorService usuarioService;

  @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response> listaJuegos() {
    return new ResponseEntity<Response>(
        new Response(Constantes.Mensaje_01, juegoService.findAll()), HttpStatus.OK);
  }

  @PostMapping(value = "/guardarJuego", produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<Response> guardarJuego(@RequestBody ProfesorRegistroJuegoDto profesorRegistroJuegoDto) {

    Juego juego = new Juego();

    juego.setNombreJuego(profesorRegistroJuegoDto.getJuego().getNombreJuego());

    juego.setFechaCreacion(LocalDate.now());

    Profesor profesor = usuarioService.getProfesorById(Math.toIntExact(profesorRegistroJuegoDto.getId()));

    List<Profesor> listaProfesores = new ArrayList<>();

    listaProfesores.add(profesor);

    juego.setProfesors(listaProfesores);

    juegoService.save(juego);

    return new ResponseEntity<Response>(new Response(Constantes.Mensaje_01, juego), HttpStatus.OK);
  }

  @PostMapping(value = "/borrarJuego", produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<Response> borrarJuego(@RequestBody BorrarJuegoDTO id) throws Exception {

    Long result = Long.valueOf(id.getId());

    Juego game = juegoService.findById(id.getId());

    int idProfesor = Math.toIntExact(game.getProfesors().get(0).getId());

    List<Pregunta> preguntas = preguntaService.getPreguntasByJuegoId(game.getId());

    for(Pregunta pregunta : preguntas){
        List<Respuesta> respuestas =  respuestaService.getAllRespuestas();
        for(Respuesta respuesta : respuestas){
          if (respuesta.getPreguntaIdpregunta().getId() == pregunta.getId()) {
            respuestaService.delete(respuesta);
          }
        }

        List<Pista>pistas = pistaService.getPistasByPreguntaIdpregunta(pregunta.getId());

        for(Pista pista : pistas){
          pistaService.delete(pista);
        }

        preguntaService.deletePregunta(pregunta.getId());
    }



    juegoService.deleteById(result);

    List<Juego> juegos = juegoService.findByProfesor(usuarioService.getProfesorById(idProfesor));

    return new ResponseEntity<Response>(new Response(Constantes.Mensaje_01, juegos), HttpStatus.OK);
  }

  @PostMapping(value = "/crearJuego", produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<Response> crearJuego(@RequestBody JuegoClassDto juegoClassDto){
    Juego juego = new Juego();

    //busco el profesor por el id
    Profesor profesor = usuarioService.getProfesorById(juegoClassDto.getIdProfesor());

    //creo la lista de profesores
    List<Profesor> lstProfesores = new ArrayList<>();

    //listas de preguntas y respuestas
    List<Pregunta> lstPreguntas = new ArrayList<>();

    lstProfesores.add(profesor);//agrego el profesor que creo el juego
    juego.setProfesors(lstProfesores);//seteo la lista de profesores en el juego

    //seteo los atributos del juego
    juego.setNombreJuego(juegoClassDto.getNombreJuego());
    juego.setFechaCreacion(LocalDate.now());

    //guardo el juego
    Juego game = juegoService.save(juego);

    // Preparar preguntas sacandolas del DTO
    for (PreguntaDto pregunta : juegoClassDto.getPreguntas()) {
      List<Respuesta> lstRespuestas = new ArrayList<>();

      //mapeo las pistas con sus respectivas preguntas
      List<Pista> pistas = pistaService.getPistasByPreguntaIdpregunta(pregunta.getId());
      List<PistaDto> pistasDto = new ArrayList<>();

      //mapeo la pregunta con su respectiva respuesta clase
      Pregunta preg = new Pregunta();//clase pregunta
      preg.setPregunta(pregunta.getPregunta());//pregunta DTO
      preg.setDificultad(pregunta.getDificultad());
      preg.setPreguntacol("");
      preg.setJuegoIdjuego(juegoService.findById(game.getId()));//seteo el juego

      //guardo la pregunta
      Pregunta cuestion = preguntaService.savePregunta(preg);//guardo la pregunta

      //guardo la primer pista
      PistaDto pista1 = pregunta.getPistas().get(0);
      Pista pistaA = new Pista();
      pistaA.setPista(pista1.getPista());
      pistaA.setPreguntaIdpregunta(cuestion);
      pistaService.save(pistaA);
      //guardo la segunda pista
      PistaDto pista2 = pregunta.getPistas().get(1);
      Pista pistaB = new Pista();
      pistaB.setPista(pista2.getPista());
      pistaB.setPreguntaIdpregunta(cuestion);
      pistaService.save(pistaB);

      //preparo respuestas
      for (RespuestaDto res: pregunta.getRespuestas() ) {
        Respuesta resp = new Respuesta();
        resp.setRespuesta(res.getRespuesta());
        resp.setCorrecto(res.getCorrecto());
        resp.setPreguntaIdpregunta(preguntaService.getPreguntaById(cuestion.getId()));
        respuestaService.saveRespuesta(resp);
        lstRespuestas.add(resp);
      }

    }

    Juego g =juegoService.save(game);
    return new ResponseEntity<Response>(
        new Response(Constantes.Mensaje_01, juegoService.findById(g.getId())), HttpStatus.OK);
  }

  @PostMapping(value = "/iniciojuego", produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Response> iniciarJuego(@RequestBody JuegoIdDTO juegoIdDTO){
    Juego juego = juegoService.findById(juegoIdDTO.getId());

    JuegoIniciadoDto juegoDto = new JuegoIniciadoDto();

    juegoDto.setNombreJuego(juego.getNombreJuego());
    juegoDto.setId(juego.getId());
    juegoDto.setPreguntas(new ArrayList<>());
    juegoDto.setFechaCreacion(juego.getFechaCreacion());

    //busco las preguntas del juego y guardo el jueogDTO
    for (Pregunta preg : juego.getPreguntas()){

      PreguntaDto preguntaDto = new PreguntaDto();
      preguntaDto.setId(preg.getId());
      preguntaDto.setPregunta(preg.getPregunta());
      preguntaDto.setDificultad(preg.getDificultad());

      juegoDto.getPreguntas().add(preguntaDto);
    }

    //seteo el juegoDTO segun las preguntas y las respuestas
    for(PreguntaDto pr : juegoDto.getPreguntas()){
      List<Respuesta> rs = respuestaService.getRespuestasByPregunta(pr.getId());
      List<RespuestaDto> respuestas = new ArrayList<>();
      for(Respuesta r : rs){
        RespuestaDto rsDto = new RespuestaDto();
        rsDto.setRespuesta(r.getRespuesta());
        rsDto.setCorrecto(r.getCorrecto());
        respuestas.add(rsDto);
      }
      pr.setRespuestas(respuestas);
      //mezclo las respuestas con metodo random
      Random r = new Random();
      int i = 0;
      for(int x = 0; x < 100 ; x++){
        i = r.nextInt(pr.getRespuestas().size());
      }
      RespuestaDto aux = pr.getRespuestas().get(i);
      pr.getRespuestas().set(i,pr.getRespuestas().get(0));
      pr.getRespuestas().set(0,aux);

      //vuelvo a mezclar las respuestas con metodo shuffle
      Collections.shuffle(pr.getRespuestas());

      //seteo las pistas con sus respectivvas preguntas
      List<Pista> pistas = pistaService.getPistasByPreguntaIdpregunta(pr.getId());

      List<PistaDto> pistasDto = new ArrayList<>();

      PistaDto pista1 = new PistaDto();
      pista1.setPista(pistas.get(0).getPista());
      pistasDto.add(pista1);
      PistaDto pista2 = new PistaDto();
      pista2.setPista(pistas.get(1).getPista());

      pistasDto.add(pista2);

      pr.setPistas(pistasDto);

    }
    //LOGGER.error("Juego: " + juegoDto.toString());

    //mezclo y retorno solo 4 preguntas nivel 1, 3 de nivel 2 y 3 de nivel 3
    JuegoIniciadoDto juegoFinal = new JuegoIniciadoDto();
    juegoFinal.setId(juegoDto.getId());
    juegoFinal.setNombreJuego(juegoDto.getNombreJuego());
    juegoFinal.setFechaCreacion(juegoDto.getFechaCreacion());

    List<PreguntaDto> preguntasNivel1 = new ArrayList<>();
    List<PreguntaDto> preguntasNivel2 = new ArrayList<>();
    List<PreguntaDto> preguntasNivel3 = new ArrayList<>();

    //separo las preguntas segun su nivel
    for(PreguntaDto p : juegoDto.getPreguntas()){
      if (p.getDificultad() == 1) {
        preguntasNivel1.add(p);
      } else if (p.getDificultad() == 2) {
        preguntasNivel2.add(p);
      } else {
        preguntasNivel3.add(p);
      }
    }

    //mezclo las preguntas de nivel1
    Collections.shuffle(preguntasNivel1);
    //mezclo las preguntas de nivel2
    Collections.shuffle(preguntasNivel2);
    //mezclo las preguntas de nivel3
    Collections.shuffle(preguntasNivel3);

    //seteo las preguntas en el juegoFinal
    juegoFinal.setPreguntas(new ArrayList<>());
    //seteo las preguntas de nivel 1
    for(int i = 0; i < 4; i++){
      juegoFinal.getPreguntas().add(preguntasNivel1.get(i));
    }
    //seteo las preguntas de nivel 2
    for(int i = 0; i < 3; i++){
      juegoFinal.getPreguntas().add(preguntasNivel2.get(i));
    }
    //seteo las preguntas de nivel 3
    for(int i = 0; i < 3; i++){
      juegoFinal.getPreguntas().add(preguntasNivel3.get(i));
    }

    return new ResponseEntity<Response>(new Response(Constantes.Mensaje_01, juegoFinal), HttpStatus.OK);
  }

  @GetMapping(value = "/juegoporid/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Response> getPreguntaById(@PathVariable("id") int id){
        Juego juego =juegoService.findById(id);
        return new ResponseEntity<Response>(new Response(Constantes.Mensaje_01, juego), HttpStatus.OK);
    }
}
