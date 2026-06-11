package com.example.direcciones.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarDireccion {
    

    @NotBlank
    private int id_direccion;

    @NotBlank 
    private String calle;

    @NotBlank
    private int numero;
    
}
