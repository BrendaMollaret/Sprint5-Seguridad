package desarrollo.sprint5.apiresttest.Controller;

import desarrollo.sprint5.apiresttest.Entity.CategoriaArticuloManufacturado;
import desarrollo.sprint5.apiresttest.Service.CategoriaArticuloManufacturadoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/CategoriaArticuloManufaturado")
public class CategoriaArticuloManufacturadoController extends BaseControllerImpl<CategoriaArticuloManufacturado, CategoriaArticuloManufacturadoServiceImpl>{
}
