package com.example.qqsm.controller;

import com.example.qqsm.dto.LoginObjetoDTO;
import com.example.qqsm.model.Profesor;
import com.example.qqsm.service.ProfesorService;
import com.example.qqsm.utils.Constantes;
import com.example.qqsm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private ProfesorService usuarioService;

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




    /*@PostMapping(value = "/verificarUsuario", produces = { MediaType.APPLICATION_JSON_VALUE })
    //para que funcione este metodo(comentado), se debe enviar un json con el nombre y el password no un formulario
    public ResponseEntity<Response> verificarUsuario(@RequestBody LoginObjetoDTO loginObjetoDTO){
    //public ResponseEntity<Response> verificarUsuario(@RequestParam() String usuario, @RequestParam() String password) {
        Boolean existe = usuarioService.existeUsuario(loginObjetoDTO.getUsuario());
        boolean existeUsuario = existe && usuarioService.getUsuariosPorNombreYPass(loginObjetoDTO.getUsuario(), loginObjetoDTO.getPassword()) != null;
        LoginDTO loginDTO = new LoginDTO();

        loginDTO.setUsuario(Boolean.TRUE?existe:Boolean.FALSE);

        loginDTO.setContraseña(Boolean.TRUE?existeUsuario:Boolean.FALSE);

        loginDTO.setDpoLogin(Boolean.TRUE?existe&&existeUsuario:Boolean.FALSE);

        if(loginDTO.getDpoLogin()){
            loginDTO.setDpoId(usuarioService.getUsuariosPorNombreYPass(loginObjetoDTO.getUsuario(), loginObjetoDTO.getPassword()).getId());
        }
        return new ResponseEntity<Response>(new Response(Constantes.Mensaje_01, loginDTO), HttpStatus.OK);
    }*/
}