package com.example.Gestion_Reuniones.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AgregarAsistente {
    
    @NotBlank
    private String primer_nombre;

    @NotBlank
    private String segundo_nombre;

    @NotBlank
    private String primer_apellido;

    @NotBlank
    private String segundo_apellido;

    @NotNull
    private int id_reunion;
}
