package com.example.qqsm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="usuario")
public class UsuarioModel {

    @Id
    @Column(name="id", unique = true, nullable = false, length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name="apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name="email", nullable = false, length = 100)
    private String email;

    @Column(name="usuario", nullable = false, length = 100)
    private String usuario;

    @Column(name="password", nullable = false, length = 100)
    private String password;


    public UsuarioModel() {
    }
}
