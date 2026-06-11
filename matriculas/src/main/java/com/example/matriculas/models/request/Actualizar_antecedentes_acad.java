package com.example.matriculas.models.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Actualizar_antecedentes_acad {

    @NotBlank
    private int id_antecedentes_academicos;

    private String logros_academicos;
    
    @NotNull
    private LocalDate anno_anterior;

    private Float prom_anno_anterior;
}