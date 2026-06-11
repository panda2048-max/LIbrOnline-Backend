package com.example.matriculas.models.request;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Actualizar_matricula {

    @NotBlank
    private int id_matriculas;
    
    @NotBlank
    private LocalDate fecha_matricula;

    @NotBlank
    private String estado_matricula;

    @NotBlank
    private int coste_matricula;
    
    @NotBlank
    private int iva;

    @NotBlank
    private  int total_matriculas;
}
