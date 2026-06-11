package com.example.Gestion_Cursos.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarAsignatura {
    @NotBlank
    private String nombre_asignatura;
}
