package com.example.direcciones.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AgregarRegion {
  
    @NotBlank
    private int id_region;

    @NotBlank 
    private String nombre_region;

    @NotNull
    private Integer id_pais;
}
