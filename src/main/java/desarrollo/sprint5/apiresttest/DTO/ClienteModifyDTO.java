package desarrollo.sprint5.apiresttest.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteModifyDTO {

    Long idCliente;
    int idRole;

    String nombre;
    String apellido;
    String telefono;
    String mail;

    //Domicilio
    String calle;
    int nroCalle;
    int pisoDpto;
    int nroDpto;
    Long idlocalidad;
}
