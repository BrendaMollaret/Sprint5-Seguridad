package desarrollo.sprint4.apiresttest.Controller;

import desarrollo.sprint4.apiresttest.Entity.Pedido;
import desarrollo.sprint4.apiresttest.Service.PedidoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>{

}