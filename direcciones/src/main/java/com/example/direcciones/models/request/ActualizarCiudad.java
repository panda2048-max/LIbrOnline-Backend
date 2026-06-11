package com.example.direcciones.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarCiudad {
  
    @NotBlank
    private int id_ciudad;

    @NotBlank 
    private String nombre_ciudad;
}
