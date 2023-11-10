package desarrollo.sprint5.apiresttest.Service;

import desarrollo.sprint5.apiresttest.Entity.Factura;
import desarrollo.sprint5.apiresttest.Repository.BaseRepository;
import desarrollo.sprint5.apiresttest.Repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura, Long> implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public FacturaServiceImpl(BaseRepository<Factura, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Page<Factura> searchFacturaByPedido(Long idPedido, Pageable pageable) throws Exception {
        try {

            Page<Factura> facturaRecuperada = facturaRepository.searchFacturaByPedido(idPedido, pageable);

            return facturaRecuperada;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
