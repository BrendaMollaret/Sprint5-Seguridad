package desarrollo.sprint5.apiresttest.Controller;

import desarrollo.sprint5.apiresttest.Entity.Domicilio;
import desarrollo.sprint5.apiresttest.Service.DomicilioServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/domicilio")
public class DomicilioController extends BaseControllerImpl<Domicilio, DomicilioServiceImpl>{

}
