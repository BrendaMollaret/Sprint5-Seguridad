package desarrollo.sprint5.apiresttest.Controller;

import desarrollo.sprint5.apiresttest.Entity.Cliente;
import desarrollo.sprint5.apiresttest.Service.ClienteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/cliente")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteServiceImpl> {


    @GetMapping("/searchById")
    public ResponseEntity<?> searchById(@RequestParam Long idCliente) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchById(idCliente));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

}
