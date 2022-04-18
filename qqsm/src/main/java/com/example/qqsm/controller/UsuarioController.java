package com.example.qqsm.controller;

import com.example.qqsm.dto.LoginDTO;
import com.example.qqsm.model.UsuarioModel;
import com.example.qqsm.service.UsuarioService;
import com.example.qqsm.utils.Constantes;
import com.example.qqsm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/obtenerUsuario")
    public ResponseEntity<UsuarioModel> getUsuario(@RequestBody String usuario, String password) {
        UsuarioModel user = usuarioService.getUsuariosPorNombreYPass(usuario, password);
        return new ResponseEntity<UsuarioModel>(user, HttpStatus.OK);
    }

    @PostMapping("/saveuser")
    public ResponseEntity<UsuarioModel> saveUsuario(@RequestBody UsuarioModel usuario) {
        usuarioService.saveUsuario(usuario);
        return new ResponseEntity<UsuarioModel>(usuario, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<UsuarioModel> updateUsuario(@RequestBody UsuarioModel usuario) {
        usuarioService.saveUsuario(usuario );
        return new ResponseEntity<UsuarioModel>(usuario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioModel> deleteUsuario(@PathVariable("id") Long id) {
        usuarioService.deleteUsuario(id);
        return new ResponseEntity<UsuarioModel>(HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UsuarioModel>> getUsuarios() {
        List<UsuarioModel> usuarios = usuarioService.getUsuarios();
        return new ResponseEntity<List<UsuarioModel>>(usuarios, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioModel> login(@RequestBody UsuarioModel usuario) {
        UsuarioModel user = usuarioService.getUsuariosPorNombreYPass(usuario.getNombre(), usuario.getPassword());
        return new ResponseEntity<UsuarioModel>(user, HttpStatus.OK);
    }

    @PostMapping(value = "/verificarUsuario", produces = { MediaType.APPLICATION_JSON_VALUE })
    //para que funcione este metodo(comentado), se debe enviar un json con el nombre y el password no un formulario
    //public ResponseEntity<Response> verificarUsuario(@RequestBody LoginObjetoDTO loginObjetoDTO)
    public ResponseEntity<Response> verificarUsuario(@RequestParam() String usuario, @RequestParam() String password) {
        Boolean existe = usuarioService.existeUsuario(usuario);
        boolean existeUsuario = existe && usuarioService.getUsuariosPorNombreYPass(usuario, password) != null;
        LoginDTO loginDTO = new LoginDTO();

        loginDTO.setUsuario(Boolean.TRUE?existe:Boolean.FALSE);

        loginDTO.setContraseña(Boolean.TRUE?existeUsuario:Boolean.FALSE);

        loginDTO.setDpoLogin(Boolean.TRUE?existe&&existeUsuario:Boolean.FALSE);

        return new ResponseEntity<Response>(new Response(Constantes.Mensaje_01, loginDTO), HttpStatus.OK);
    }
}