package com.example.Gestion_Cursos.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarCurso {
    @NotBlank
    private int id_curso;

    @NotBlank
    private String letra;

    @NotBlank
    private String nivel_curso;

    @NotBlank
    private int id_sala;

    @NotBlank
    private int id_docente;
}
