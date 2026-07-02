package com.example.Gestion_Cursos.models.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "curso_estudiante", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_curso", "id_estudiante"})
})
public class CursoEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_curso", nullable = false)
    @JsonProperty("id_curso")
    private int cursoId;

    @Column(name = "id_estudiante", nullable = false)
    @JsonProperty("id_estudiante")
    private int estudianteId;
}
