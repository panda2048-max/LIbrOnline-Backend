package example.Notas.model.request;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarEvaluacion {

    @NotBlank
    private Date fecha_evaluacion;

    @NotBlank
    private String asignatura;

    @NotBlank
    private String tipo_evaluacion;

    @NotBlank
    private int id_usuarios;
}
