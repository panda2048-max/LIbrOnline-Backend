package com.example.matriculas.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "hoja_de_vida")
public class Hoja_de_vida {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_hoja;

    @Column(nullable = false)
    private LocalDate fecha_creacion;

    @Column(nullable = false)
    private int id_usuarios;


}
