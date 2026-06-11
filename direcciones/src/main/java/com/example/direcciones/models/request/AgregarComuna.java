package com.example.direcciones.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AgregarComuna {
  
    @NotBlank
    private int id_comuna;

    @NotBlank 
    private String nombre_comuna;

    @NotNull
    private Integer id_ciudad;
}
