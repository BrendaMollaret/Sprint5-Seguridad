package desarrollo.sprint5.apiresttest.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DomicilioDTO {

    Long idDomicilio;
    String calle;
    int nroCalle;
    int pisoDpto;
    int nroDpto;

    Long idLocalidad;

}
