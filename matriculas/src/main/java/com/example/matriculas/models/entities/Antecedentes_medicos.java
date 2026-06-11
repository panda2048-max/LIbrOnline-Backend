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
@Table(name = "antecedentes_medicos")
public class Antecedentes_medicos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_antecedentes_medico;

    @Column(nullable = false)
    private String hospital_nacimiento;

    private  String enfermedades;

    private String lesiones;

    private String medicamentos;

    private LocalDate fecha_enfermedad;

    private LocalDate fecha_lesiones;

    private String estado_enfermedad;

    @ManyToOne
    @JoinColumn(name = "id_hoja", nullable = false)
    private Hoja_de_vida hoja_de_vida;
}
