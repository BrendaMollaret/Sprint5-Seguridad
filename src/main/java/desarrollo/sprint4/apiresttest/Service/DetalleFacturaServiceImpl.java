package desarrollo.sprint4.apiresttest.Service;

import desarrollo.sprint4.apiresttest.Entity.DetalleFactura;
import desarrollo.sprint4.apiresttest.Repository.BaseRepository;
import desarrollo.sprint4.apiresttest.Repository.DetalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleFacturaServiceImpl extends BaseServiceImpl<DetalleFactura, Long> implements DetalleFacturaService {

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    public DetalleFacturaServiceImpl(BaseRepository<DetalleFactura, Long> baseRepository) {
        super(baseRepository);
    }

}
