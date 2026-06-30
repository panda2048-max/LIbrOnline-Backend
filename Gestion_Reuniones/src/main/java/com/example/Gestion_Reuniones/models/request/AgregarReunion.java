package com.example.Gestion_Reuniones.models.request;

import java.sql.Date;
import java.sql.Time;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AgregarReunion {
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

    @NotBlank
    private int id_usuarios;

    private Integer id_usuario_2;

    @NotNull
    private int id_sala;

}
