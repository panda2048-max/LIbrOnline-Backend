package com.example.matriculas.models.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Actualizar_hoja_vida {
    
    @NotBlank
    private int id_hoja_vida;
    
    @NotNull
    private LocalDate fecha_cracion;
    
}
