package com.example.direcciones.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "comuna")
@Inheritance(strategy = InheritanceType.JOINED)
public class Comuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_comuna;

    @Column(nullable = false)
    private String nombre_comuna;

    @ManyToOne
    @JoinColumn(name = "id_ciudad", nullable = false)
    private Ciudad ciudad;

}
