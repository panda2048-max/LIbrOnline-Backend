package com.example.Creacion_Eventos.models.request;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AgregarCalendario {

    @NotNull
    private Date fecha_inicio;
    
    @NotNull
    private Date fecha_fin;

    @NotNull
    private int id_evento;
}
