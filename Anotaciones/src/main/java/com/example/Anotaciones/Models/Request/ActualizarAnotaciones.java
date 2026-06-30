package com.example.Anotaciones.Models.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarAnotaciones {

    @NotBlank(message = "El ID de la anotación es obligatorio")
    private int id;
    @NotBlank(message = "El tipo de anotación es obligatorio")
    private String tipo;
    @NotBlank(message = "La descripción de la anotación es obligatoria")
    private String descripcion;
    private Integer id_inspector;

}
