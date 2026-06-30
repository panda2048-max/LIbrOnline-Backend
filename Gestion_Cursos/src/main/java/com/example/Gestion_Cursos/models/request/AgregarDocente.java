package com.example.Gestion_Cursos.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarDocente {
    @NotBlank
    private String nombre_docente;
    
    @NotBlank
    private String especialidad;

    private Integer id_usuario;
}
