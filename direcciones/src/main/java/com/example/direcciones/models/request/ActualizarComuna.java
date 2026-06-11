package com.example.direcciones.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarComuna {
  
    @NotBlank
    private int id_comuna;

    @NotBlank 
    private String nombre_comuna;
}
