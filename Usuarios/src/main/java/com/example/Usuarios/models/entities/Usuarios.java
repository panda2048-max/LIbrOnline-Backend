package com.example.Usuarios.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuarios;

    @Column(name = "run_usuario", nullable = false)
    private String runUsuario;

    @Column(nullable = false)
    private String primer_nombre;

    @Column(nullable = false)
    private String segundo_nombre;

    @Column(nullable = false)
    private String ap_paterno;

    @Column(nullable = false)
    private String ap_materno;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String telefono;
}