package example.Notas.model.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "notas")
public class Nota{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_nota;

    @Column(nullable = false)
    private Double calificacion;

    
    private Double prom_calificacion;

    @ManyToOne
    @JoinColumn(name= "id_evaluacion",nullable = false)
    private Evaluacion evaluacion;

    @Column(nullable = false)
    private String rut_usuario;
}