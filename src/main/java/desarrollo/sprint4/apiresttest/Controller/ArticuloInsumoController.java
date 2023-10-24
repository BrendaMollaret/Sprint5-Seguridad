package desarrollo.sprint4.apiresttest.Controller;

import desarrollo.sprint4.apiresttest.Entity.ArticuloInsumo;
import desarrollo.sprint4.apiresttest.Service.ArticuloInsumoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/articuloInsumo")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoServiceImpl>{

}
