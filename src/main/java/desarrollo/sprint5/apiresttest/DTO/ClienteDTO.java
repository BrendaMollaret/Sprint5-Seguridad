package desarrollo.sprint5.apiresttest.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    String nombre;
    String apellido;
    String telefono;
    String mail;
    LocalDate fechaHoraModificacionCliente;
    //Falta direccion
}
