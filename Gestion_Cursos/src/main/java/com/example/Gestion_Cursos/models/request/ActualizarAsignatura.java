package com.example.Gestion_Cursos.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarAsignatura {
    @NotBlank
    private int id_asignatura;

    @NotBlank
    private String nombre_asignatura;
}
