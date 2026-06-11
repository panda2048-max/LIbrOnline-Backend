package com.example.matriculas.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Agregar_antecedentess_apo {
    
    @NotBlank
    private String nivel_academico;

    @NotBlank
    private int numero_hijos;

    @NotBlank
    private String estado_civil;

    @NotNull
    private Integer id_hoja;

}
