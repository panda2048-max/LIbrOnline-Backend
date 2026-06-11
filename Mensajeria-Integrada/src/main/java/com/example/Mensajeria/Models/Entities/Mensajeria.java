package com.example.Mensajeria.Models.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Mensajeria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String titulo;
    
    @Column(nullable = false)
    private String descripcion;
    
    @Column(nullable = false)
    private String destinatario; 
    
    @Column(nullable = false)
    private LocalDateTime fechaEnvio;
    
    @Column(nullable = false)
    private int id_usuarios;
    
}
