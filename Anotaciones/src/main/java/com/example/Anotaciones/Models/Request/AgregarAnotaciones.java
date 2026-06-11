package com.example.Anotaciones.Models.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

import lombok.Data;
@Data
public class AgregarAnotaciones {
    
    @NotBlank(message = "El tipo de anotación es obligatorio")
    private String tipo;
    
    @NotBlank(message = "La descripción de la anotación es obligatoria")
    private String descripcion;
    
    @NotNull(message = "La fecha de creación de la anotación es obligatoria")
    private LocalDate   fechaCreacion;
    
    @NotBlank
    private int id_usuarios;
    
}
