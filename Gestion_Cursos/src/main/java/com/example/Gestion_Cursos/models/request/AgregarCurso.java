package com.example.Gestion_Cursos.models.request;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AgregarCurso {

    @NotBlank
    private String letra;

    @NotBlank
    private String nivel_curso;

    @NotBlank
    private int id_sala;

    @NotBlank
    private int id_docente;

    @NotNull
    private List<Integer> id_asignaturas;

   @NotNull
    private int id_usuarios;
    

}
