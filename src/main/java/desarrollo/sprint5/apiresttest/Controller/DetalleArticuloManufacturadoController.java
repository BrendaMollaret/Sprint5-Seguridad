package desarrollo.sprint5.apiresttest.Controller;

import desarrollo.sprint5.apiresttest.Entity.DetalleArticuloManufacturado;
import desarrollo.sprint5.apiresttest.Service.DetalleArticuloManufacturadoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/detalleArticuloManufacturado")
public class DetalleArticuloManufacturadoController extends BaseControllerImpl<DetalleArticuloManufacturado, DetalleArticuloManufacturadoServiceImpl>{
}
