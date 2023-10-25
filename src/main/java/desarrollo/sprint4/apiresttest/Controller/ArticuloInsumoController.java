package desarrollo.sprint4.apiresttest.Controller;

import desarrollo.sprint4.apiresttest.Entity.ArticuloInsumo;
import desarrollo.sprint4.apiresttest.Service.ArticuloInsumoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/articuloInsumo")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoServiceImpl>{

    @GetMapping("/searchByNombre")
    public ResponseEntity<?> searchByNombre(@RequestParam String nombre, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByNombre(nombre, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchByRubroNombre")
    public ResponseEntity<?> searchByRubroNombre(@RequestParam String nombreRubro, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByRubroNombre(nombreRubro, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

}
