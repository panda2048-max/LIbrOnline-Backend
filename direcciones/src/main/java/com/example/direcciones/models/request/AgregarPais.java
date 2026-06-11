package com.example.direcciones.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarPais {
  
    @NotBlank
    private int id_pais;

    @NotBlank 
    private String nombre_pais;
}
