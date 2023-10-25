package desarrollo.sprint4.apiresttest.Service;

import desarrollo.sprint4.apiresttest.Entity.Pedido;
import desarrollo.sprint4.apiresttest.Enumeration.EstadoPedido;
import desarrollo.sprint4.apiresttest.Repository.BaseRepository;
import desarrollo.sprint4.apiresttest.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Page<Pedido> searchHistorialPedidoByCliente(Long idCliente, Pageable pageable) throws Exception {
        try {

            Page<Pedido> pedidos = pedidoRepository.searchHistorialPedidoByCliente(idCliente, pageable);

            return pedidos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Pedido> searchPedidosByRangoFechasYCliente(Long idCliente, LocalDate fechaInicio, LocalDate fechaFin, Pageable pageable) throws Exception {
        try {

            Page<Pedido> pedidos = pedidoRepository.searchPedidosByRangoFechasYCliente(idCliente, fechaInicio, fechaFin, pageable);

            return pedidos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Pedido> searchByEstado(EstadoPedido estadoPedido, Pageable pageable) throws Exception {
        try {

            Page<Pedido> pedidos = pedidoRepository.searchByEstado(estadoPedido, pageable);

            return pedidos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
