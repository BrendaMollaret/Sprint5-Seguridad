package desarrollo.sprint5.apiresttest.Controller;

import desarrollo.sprint5.apiresttest.Entity.Pedido;
import desarrollo.sprint5.apiresttest.Enumeration.EstadoPedido;
import desarrollo.sprint5.apiresttest.Service.PedidoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/pedido")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>{

    @GetMapping("/searchHistorialPedidoByCliente")
    public ResponseEntity<?> searchHistorialPedidoByCliente(@RequestParam Long idCliente, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchHistorialPedidoByCliente(idCliente, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchPedidosByRangoFechasYCliente")
    public ResponseEntity<?> searchPedidosByRangoFechasYCliente(@RequestParam Long idCliente, LocalDate fechaInicio,LocalDate fechaFin, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchPedidosByRangoFechasYCliente(idCliente, fechaInicio,fechaFin, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchByEstado")
    public ResponseEntity<?> searchByEstado(@RequestParam EstadoPedido estadoPedido, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByEstado(estadoPedido, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

}
