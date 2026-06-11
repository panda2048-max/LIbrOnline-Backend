package example.Notas.model.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "evaluacion")
public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_evaluacion;

    @Column(nullable = false)
    private Date fecha_evaluacion;

    @Column(nullable = false)
    private String asignatura;

    @Column(nullable = false)
    private String tipo_evaluacion;

    @Column(nullable = false)
    private int id_usuarios;
    
}
