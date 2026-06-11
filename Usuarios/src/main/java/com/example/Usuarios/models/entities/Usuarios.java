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

    @Column(nullable = false)
    private String run_usuario;

    @Column(nullable = false)
    private String primer_nombre;

    @Column(nullable = false)
    private String segundo_nombre;

    @Column(nullable = false)
    private String ap_paterno;

    @Column(nullable = false)
    private String ap_materno;

    @Column(nullable = false)
    private String telefono;
}