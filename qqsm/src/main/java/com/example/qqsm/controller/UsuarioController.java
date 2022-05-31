package com.example.qqsm.controller;

import com.example.qqsm.dto.*;
import com.example.qqsm.model.Juego;
import com.example.qqsm.model.Materia;
import com.example.qqsm.model.Profesor;
import com.example.qqsm.service.JuegoService;
import com.example.qqsm.service.MateriaService;
import com.example.qqsm.service.ProfesorService;
import com.example.qqsm.utils.Constantes;
import com.example.qqsm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private ProfesorService usuarioService;

    @Autowired
    MateriaService materiaService;

    @Autowired
    JuegoService juegoService;

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Response> getUsuario(@PathVariable("id") int id) {
        Profesor usuario = usuarioService.getProfesorById(id);
        return new ResponseEntity<Response>(new Response(Constantes.Mensaje_01, usuario), HttpStatus.OK);
    }

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listar() {
        List<Profesor> usuarios = usuarioService.getProfesors();
        return new ResponseEntity<Response>(new Response(Constantes.Mensaje_01, usuarios), HttpStatus.OK);
    }

    @PostMapping(value = "/obtenerUsuario", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Response> getUsuario(@RequestBody LoginObjetoDTO login) {

        List<Profesor> user = usuarioService.getProfesors();

        for (Profesor pro : user) {
            if (pro.getUser().equals(login.getUsuario()) && pro.getPassword().equals(login.getPassword())) {
                return new ResponseEntity<Response>(new Response(Constantes.Mensaje_01, pro), HttpStatus.OK);
            }
        }
        return new ResponseEntity<Response>(new Response(Constantes.Mensaje_01, null), HttpStatus.OK);
    }

    @PostMapping(value = "/registrar", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Response> registrar(@RequestBody ProfesorRegistroDto profesor) {
        Profesor usuario = new Profesor();
        usuario.setNombre(profesor.getNombre());
        usuario.setApellido(profesor.getApellido());
        usuario.setEmail(profesor.getEmail());
        usuario.setUser(profesor.getUser());
        usuario.setPassword(profesor.getPassword());
        usuario.setDireccion(profesor.getDireccion());

    if (!usuario.getMaterias().isEmpty()) {
      for (Materia mat : profesor.getMaterias()) {
        usuario
            .getMaterias()
            .add(materiaService.getMateriaByNombre_materia(mat.getNombreMateria()));
      }
    }
        //salvo al profesor en la base de datos
        usuarioService.addProfesor(usuario);
        return new ResponseEntity<Response>(new Response(Constantes.Mensaje_01,usuario), HttpStatus.OK);
    }

    @PostMapping(value = "/GuardarMateria", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Response> guardarMateria(@RequestBody MateriaDto materiaNombre) {
        Materia materia = new Materia();
        materia.setNombreMateria(materiaNombre.getNombreMateria());

        materiaService.addMateria(materia);

        return new ResponseEntity<Response>(new Response(Constantes.Mensaje_01, materia), HttpStatus.OK);
    }

    @GetMapping("/materiaPorNombre/{nombre}")
    public ResponseEntity<Response> materiaPorNombre(@PathVariable String nombre){
        Materia materia = materiaService.getMateriaByNombre_materia(nombre);
        return new ResponseEntity<Response>(new Response(Constantes.Mensaje_01, materia), HttpStatus.OK);
    }

    @GetMapping("/listarMaterias")
    public ResponseEntity<Response> listarMaterias(){

        Iterable<Materia> materias = materiaService.getAllMateria();

        return new ResponseEntity<Response>(new Response(Constantes.Mensaje_01, materias), HttpStatus.OK);
    }

    @PostMapping(value = "/verificarUsuario", produces = { MediaType.APPLICATION_JSON_VALUE })
    //para que funcione este metodo(comentado), se debe enviar un json con el nombre y el password no un formulario
    public ResponseEntity<Response> verificarUsuario(@RequestBody LoginObjetoDTO loginObjetoDTO){
    //public ResponseEntity<Response> verificarUsuario(@RequestParam() String usuario, @RequestParam() String password) {
        Boolean existe = usuarioService.existeUsuario(loginObjetoDTO.getUsuario());
        boolean existeUsuario = existe && usuarioService.getUsuariosPorNombreYPass(loginObjetoDTO.getUsuario(), loginObjetoDTO.getPassword()) != null;
        LoginDTO loginDTO = new LoginDTO();

        loginDTO.setUsuario(Boolean.TRUE?existe:Boolean.FALSE);

        loginDTO.setContraseña(Boolean.TRUE?existeUsuario:Boolean.FALSE);

        loginDTO.setDpoLogin(Boolean.TRUE?existe&&existeUsuario:Boolean.FALSE);

        loginDTO.setDpoId(usuarioService.getUsuariosPorNombreYPass(loginObjetoDTO.getUsuario(), loginObjetoDTO.getPassword()).getId());

        return new ResponseEntity<Response>(new Response(Constantes.Mensaje_01, loginDTO), HttpStatus.OK);
    }

    @GetMapping(value="/borrarUsuario/{id}", produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Response> borrarUsuario(@PathVariable(value = "id") int id){
        usuarioService.deleteProfesor(id);
        return new ResponseEntity<Response>(new Response(Constantes.Mensaje_01, id    ), HttpStatus.OK);
    }






}