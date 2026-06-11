package com.example.matriculas.models.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Agregar_antecedentes_med {
   
    @NotBlank
    private String hospital_nacimiento;

    private String enfermedades;

    private String lesiones;

    private String medicamentos;

    private LocalDate fecha_enfermedad;

    private LocalDate fecha_lesiones;

    private String estado_enfermedad;

    @NotNull
    private Integer id_hoja;
}
