package com.example.Gestion_Reuniones.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarSala {
    
    @NotBlank
    private String piso;
}
