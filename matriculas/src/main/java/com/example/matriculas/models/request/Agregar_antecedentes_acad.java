package com.example.matriculas.models.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Agregar_antecedentes_acad {

    private String logros_academicos;
    
    @NotNull
    private LocalDate anno_anterior;

    private Float prom_anno_anterior;

    @NotNull
    private int id_hoja;
}
