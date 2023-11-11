package desarrollo.sprint5.apiresttest.Service;

import desarrollo.sprint5.apiresttest.Entity.Cliente;
import desarrollo.sprint5.apiresttest.Entity.Localidad;
import org.springframework.data.repository.query.Param;

public interface LocalidadService extends BaseService<Localidad,Long>{

    Localidad searchById(Long idLocalidad) throws Exception;
}
