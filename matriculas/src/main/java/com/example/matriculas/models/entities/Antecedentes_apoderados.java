package com.example.matriculas.models.entities;

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
@Table(name = "antecedentes_apoderados")
public class Antecedentes_apoderados {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_antecedentes_apoderados;

    @Column(nullable = false)
    private String nivel_academico;

    @Column(nullable = false)
    private int numero_hijos;

    @Column(nullable = false)
    private String estado_civil;

    @ManyToOne
    @JoinColumn(name = "id_hoja", nullable = false)
    private Hoja_de_vida hoja_de_vida;
}
