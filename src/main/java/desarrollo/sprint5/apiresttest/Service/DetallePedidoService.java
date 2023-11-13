package desarrollo.sprint5.apiresttest.Service;

import desarrollo.sprint5.apiresttest.DTO.DetallePedidoDTO;
import desarrollo.sprint5.apiresttest.Entity.DetallePedido;


public interface DetallePedidoService extends BaseService<DetallePedido,Long>{

    DetallePedido addToCart(DetallePedidoDTO detallePedidoDTO) throws Exception;
}
