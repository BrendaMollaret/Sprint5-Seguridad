package desarrollo.sprint5.apiresttest.Service;

import desarrollo.sprint5.apiresttest.Entity.Domicilio;
import org.springframework.data.repository.query.Param;

public interface DomicilioService extends BaseService<Domicilio,Long>{

    boolean domicilioPerteneceAlCliente(Long idDomicilio, Long idCliente) throws Exception;
}
