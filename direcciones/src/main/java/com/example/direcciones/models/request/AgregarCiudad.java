package com.example.direcciones.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AgregarCiudad {
  
    @NotBlank
    private int id_ciudad;

    @NotBlank 
    private String nombre_ciudad;

    @NotNull
    private Integer id_region;
}
