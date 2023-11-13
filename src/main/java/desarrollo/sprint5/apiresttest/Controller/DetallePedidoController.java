package desarrollo.sprint5.apiresttest.Controller;

import desarrollo.sprint5.apiresttest.DTO.DetallePedidoDTO;
import desarrollo.sprint5.apiresttest.Entity.DetallePedido;
import desarrollo.sprint5.apiresttest.Service.DetallePedidoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/detallePedido")
public class DetallePedidoController extends BaseControllerImpl<DetallePedido, DetallePedidoServiceImpl>{

    @PostMapping(value = "addToCart")
    public ResponseEntity<?> addToCart(@RequestBody DetallePedidoDTO detallePedidoDTO)
    {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.addToCart(detallePedidoDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
