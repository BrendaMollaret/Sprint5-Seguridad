package desarrollo.sprint5.apiresttest.DTO;

import desarrollo.sprint5.apiresttest.Entity.Domicilio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    List <Domicilio> domicilios;

    /*
    Long idDomicilio;
    String calle;
    int nroCalle;
    int pisoDpto;
    int nroDpto;
    Long idlocalidad;
    */
}
