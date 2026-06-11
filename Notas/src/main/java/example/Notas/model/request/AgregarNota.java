package example.Notas.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AgregarNota {

    @NotBlank
    private String calificacion;

    @NotNull
    private int id_evaluacion;
    
    @NotBlank
    private String rut_usuario;
    
}
