package desarrollo.sprint5.apiresttest.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterEmployeeRequest {
    String username;
    String provisionalPassword;
    String role;

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
