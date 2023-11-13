package desarrollo.sprint5.apiresttest.DTO;

import desarrollo.sprint5.apiresttest.Entity.Domicilio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    String username;

    String nombre;
    String apellido;
    String telefono;
    String mail;
    LocalDate fechaHoraModificacionCliente;
    //Falta direccion

    List<Domicilio> domicilioList;
}
