package com.example.Gestion_Reuniones.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarSala {
    @NotBlank
    private int id_sala;

    @NotBlank
    private String piso;
}
