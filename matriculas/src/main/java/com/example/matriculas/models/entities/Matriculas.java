package com.example.matriculas.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "matriculas")
public class Matriculas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_matriculas;

    @Column(nullable = false)
    private LocalDate fecha_matricula;

    @Column(nullable = false)
    private String estado_matricula;

    @Column(nullable = false)
    private int coste_matricula;
    
    @Column(nullable = false)
    private int iva;

    @Column(nullable = false)
    private  int total_matriculas;

    @ManyToOne
    @JoinColumn(name = "id_hoja", nullable = false)
    private Hoja_de_vida hoja_de_vida;
}
