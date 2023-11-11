package desarrollo.sprint5.apiresttest.Controller;

import desarrollo.sprint5.apiresttest.Entity.Cliente;
import desarrollo.sprint5.apiresttest.Entity.Localidad;
import desarrollo.sprint5.apiresttest.Service.LocalidadServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/localidad")
public class LocalidadController extends BaseControllerImpl<Localidad, LocalidadServiceImpl>{
}
