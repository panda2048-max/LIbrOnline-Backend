package com.example.Creacion_Eventos.models.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data 
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_evento;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String asunto;

    @Column(nullable = false)
    private Date fecha_inicio;

    @Column(nullable = false)
    private Date fecha_fin;

    @Column(nullable = false)
    private String tipo_evento;

    @Column(nullable = false)
    private int id_usuarios;
}
