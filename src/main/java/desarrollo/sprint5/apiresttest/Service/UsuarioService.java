package desarrollo.sprint5.apiresttest.Service;

import desarrollo.sprint5.apiresttest.Entity.Usuario;
import org.springframework.data.repository.query.Param;

public interface UsuarioService extends BaseService<Usuario, Long>{

    Usuario findUserByUsername(String username) throws Exception;
}
