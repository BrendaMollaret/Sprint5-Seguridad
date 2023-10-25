package desarrollo.sprint4.apiresttest.Controller;

import desarrollo.sprint4.apiresttest.Entity.Factura;
import desarrollo.sprint4.apiresttest.Service.FacturaServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/factura")
public class FacturaController extends BaseControllerImpl<Factura, FacturaServiceImpl>{

    @GetMapping("/searchFacturaByPedido")
    public ResponseEntity<?> searchFacturaByPedido(@RequestParam Long idPedido, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchFacturaByPedido(idPedido, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

}
