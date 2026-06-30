package com.example.Gestion_Reuniones.models.request;

import java.sql.Date;
import java.sql.Time;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarReunion {
    @NotBlank
    private int id_reunion;

    @NotBlank
    private Date fecha;

    @NotBlank
    private Time hora_inicio;

    @NotBlank
    private Time hora_fin;

    @NotBlank
    private String asunto;

    @NotBlank
    private String estado;

    private Integer id_usuario_2;
}
