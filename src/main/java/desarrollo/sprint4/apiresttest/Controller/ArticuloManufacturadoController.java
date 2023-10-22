package desarrollo.sprint4.apiresttest.Controller;

import desarrollo.sprint4.apiresttest.Entity.ArticuloManufacturado;

import desarrollo.sprint4.apiresttest.Service.ArticuloManufacturadoServiceImpl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/articulomanufacturado")
public class ArticuloManufacturadoController extends BaseControllerImpl<ArticuloManufacturado, ArticuloManufacturadoServiceImpl> {

}
