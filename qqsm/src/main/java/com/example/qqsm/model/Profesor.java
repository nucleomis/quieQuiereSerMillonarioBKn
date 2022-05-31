package com.example.qqsm.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "profesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprofesor")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 45)
    private String apellido;

    @Column(name = "direccion", nullable = false, length = 45)
    private String direccion;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "user", nullable = false, length = 45)
    private String user;

    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @ManyToMany
    @JoinTable(name = "materia_has_profesor",
            joinColumns = @JoinColumn(name = "profesor_idprofesor"),
            inverseJoinColumns = @JoinColumn(name = "materia_idmateria"))
    private List<Materia> materias = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "juego_has_profesor",
            joinColumns = @JoinColumn(name = "profesor_idprofesor"),
            inverseJoinColumns = @JoinColumn(name = "juego_idjuego"))
    private List<Juego> juegos = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public List<Juego> getJuegos() {
        return juegos;
    }

    public void setJuegos(List<Juego> juegos) {
        this.juegos = juegos;
    }

}