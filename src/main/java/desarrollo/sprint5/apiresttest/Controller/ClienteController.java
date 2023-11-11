package desarrollo.sprint5.apiresttest.Controller;

import desarrollo.sprint5.apiresttest.DTO.ClienteDTO;
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
    public ResponseEntity<?> searchById(Long idCliente) {
        try {
            Cliente cliente = servicio.searchById(idCliente);
            return ResponseEntity.status(HttpStatus.OK).body(cliente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/showProfile")
    public ResponseEntity<?> showProfile(@RequestHeader(name = "Authorization") String token) {
        try {
            //ClienteDTO cliente = servicio.showProfile(token);
            return ResponseEntity.status(HttpStatus.OK).body(servicio.showProfile(token));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @PutMapping("/updateCliente")
    public ResponseEntity<?> updateCliente(@RequestHeader(name = "Authorization") String token, @RequestBody ClienteDTO clienteActualizado) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.updateCliente(token, clienteActualizado));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Los datos de la solicitud son inválidos. Por favor, revise los datos e intente de nuevo.\"}");
        }
    }



}
