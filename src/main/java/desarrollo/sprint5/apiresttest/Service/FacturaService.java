package desarrollo.sprint5.apiresttest.Service;

import desarrollo.sprint5.apiresttest.Entity.Factura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FacturaService extends BaseService<Factura, Long>{

    Page<Factura> searchFacturaByPedido(Long idPedido, Pageable pageable) throws Exception;
}
