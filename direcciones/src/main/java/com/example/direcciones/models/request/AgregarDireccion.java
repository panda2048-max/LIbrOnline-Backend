package com.example.direcciones.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AgregarDireccion {
    
    @NotBlank
    private int id_direccion;

    @NotBlank
    private String calle;

    @NotBlank
    private int numero;

    @NotBlank
    private int id_usuarios;

    @NotNull
    private Integer id_comuna;
}
