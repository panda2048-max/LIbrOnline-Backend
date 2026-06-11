package com.example.direcciones.models.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarRegion {
  
    @NotBlank
    private int id_region;

    @NotBlank 
    private String nombre_region;
}
