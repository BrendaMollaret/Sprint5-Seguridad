package desarrollo.sprint4.apiresttest.Service;

import desarrollo.sprint4.apiresttest.Entity.Pedido;
import desarrollo.sprint4.apiresttest.Enumeration.EstadoPedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface PedidoService extends BaseService<Pedido,Long>{

    Page<Pedido> searchHistorialPedidoByCliente(Long idCliente, Pageable pageable) throws Exception;

    Page<Pedido> searchPedidosByRangoFechasYCliente(Long idCliente, LocalDate fechaInicio, LocalDate fechaFin, Pageable pageable) throws Exception;

    Page<Pedido> searchByEstado(EstadoPedido estadoPedido, Pageable pageable) throws Exception;

}
