package com.example.matriculas.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Actualizar_antecedentess_apo {
    
    @NotBlank
    private int id_antecedentes_apo;

    @NotBlank
    private String nivel_academico;

    @NotBlank
    private int numero_hijos;

    @NotBlank
    private String estado_civil;

}
