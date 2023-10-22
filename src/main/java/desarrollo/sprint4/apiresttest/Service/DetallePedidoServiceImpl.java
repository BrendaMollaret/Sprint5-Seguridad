package desarrollo.sprint4.apiresttest.Service;

import desarrollo.sprint4.apiresttest.Entity.DetallePedido;
import desarrollo.sprint4.apiresttest.Entity.Pedido;
import desarrollo.sprint4.apiresttest.Repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoServiceImpl extends BaseServiceImpl<DetallePedido, Long> implements DetallePedidoService {

    @Autowired
    private DetallePedidoService detallePedidoService;

    public DetallePedidoServiceImpl(BaseRepository<DetallePedido, Long> baseRepository, DetallePedidoService detallePedidoService) {
        super(baseRepository);
        this.detallePedidoService = detallePedidoService;
    }
}
