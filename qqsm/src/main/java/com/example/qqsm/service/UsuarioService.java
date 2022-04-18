package com.example.qqsm.service;

import com.example.qqsm.model.UsuarioModel;
import com.example.qqsm.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public UsuarioModel getUsuariosPorNombreYPass(String nombre, String pass) {

        ArrayList<UsuarioModel> usuarios = (ArrayList<UsuarioModel>) usuarioRepository.findAll();

        UsuarioModel user = null;
        for (UsuarioModel usuario : usuarios) {
            if (usuario.getNombre().equals(nombre) && usuario.getPassword().equals(pass)) {
                user = usuario;
            }
        }
        return user;
    }

    public Optional<UsuarioModel> getUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public void saveUsuario(UsuarioModel usuario) {
        usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public ArrayList<UsuarioModel> getUsuarios() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public boolean existeUsuario(String nombre) {
        ArrayList<UsuarioModel> usuarios = (ArrayList<UsuarioModel>) usuarioRepository.findAll();
        for (UsuarioModel usuario : usuarios) {
            if (usuario.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public boolean existeUsuarioYPass(String nombre, String pass) {
        ArrayList<UsuarioModel> usuarios = (ArrayList<UsuarioModel>) usuarioRepository.findAll();
        for (UsuarioModel usuario : usuarios) {
            if (usuario.getNombre().equals(nombre) && usuario.getPassword().equals(pass)) {
                return true;
            }
        }
        return false;
    }

}
