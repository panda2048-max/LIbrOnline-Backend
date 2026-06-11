package example.Notas.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarNota {
    @NotBlank
    private int id_nota;
    @NotBlank
    private String calificacion;

    
}
