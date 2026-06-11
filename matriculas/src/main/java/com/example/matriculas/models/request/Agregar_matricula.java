package com.example.matriculas.models.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Agregar_matricula {

    @NotNull
    private LocalDate fecha_matricula;

    @NotBlank
    private String estado_matricula;

    @NotBlank
    private int coste_matricula;
    
    @NotBlank
    private int iva;

    @NotBlank
    private  int total_matriculas;

    @NotNull
    private Integer id_hoja;
}
