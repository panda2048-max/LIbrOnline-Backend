package com.example.Creacion_Eventos.models.request;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarEvento {

    @NotBlank
    private int id_evento;

   @NotBlank
    private String titulo;
    
    @NotBlank
    private String asunto;

    @NotBlank
    private Date fecha_inicio;

    @NotBlank
    private Date fecha_fin;

    @NotBlank
    private String tipo_evento;
}
