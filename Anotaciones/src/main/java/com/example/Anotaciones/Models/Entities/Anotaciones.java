package com.example.Anotaciones.Models.Entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "anotaciones")
@Data


public class Anotaciones {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private LocalDate fechaCreacion;

    @Column(nullable = false)
    private int id_usuarios;
}
