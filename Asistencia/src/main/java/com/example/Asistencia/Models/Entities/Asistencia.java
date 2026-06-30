package com.example.Asistencia.Models.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "asistencias")
@Inheritance(strategy = InheritanceType.JOINED)
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String estudiante; 

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private int id_usuarios;

    @Column(name = "id_curso")
    private Integer id_curso;

}