package desarrollo.sprint4.apiresttest.Controller;

import desarrollo.sprint4.apiresttest.Entity.UnidadMedida;
import desarrollo.sprint4.apiresttest.Service.UnidadMedidaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/unidad_medida")
public class UnidadMedidaController extends BaseControllerImpl<UnidadMedida, UnidadMedidaServiceImpl>{
}
