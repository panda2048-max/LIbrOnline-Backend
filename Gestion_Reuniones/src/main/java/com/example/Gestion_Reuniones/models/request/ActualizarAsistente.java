package com.example.Gestion_Reuniones.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarAsistente {
    @NotBlank
    private int id_asistente;

    @NotBlank
    private String primer_nombre;

    @NotBlank
    private String segundo_nombre;

    @NotBlank
    private String primer_apellido;

    @NotBlank
    private String segundo_apellido;
}
