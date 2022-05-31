package com.example.qqsm.service;

import com.example.qqsm.model.Materia;
import com.example.qqsm.repositories.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {
    @Autowired
    private MateriaRepository materiaService;


   public void addMateria(Materia materia){
       materiaService.save(materia);
   }

   public Materia getMateriaByNombre_materia(String nombre_materia){

       return materiaService.findByNombreMateria(nombre_materia);
   }

   public Optional<Materia> getMateriaById(Integer id){
       return materiaService.findById(id);
   }

   public List<Materia> getAllMateria(){
       return (List<Materia>) materiaService.findAll();
   }
}
