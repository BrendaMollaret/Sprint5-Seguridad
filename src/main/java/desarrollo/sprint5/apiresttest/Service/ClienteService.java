package desarrollo.sprint5.apiresttest.Service;

import desarrollo.sprint5.apiresttest.DTO.ClienteDTO;
import desarrollo.sprint5.apiresttest.Entity.Cliente;

public interface ClienteService extends BaseService<Cliente,Long>{

    Cliente searchById(Long idCliente) throws Exception;

    ClienteDTO showProfile(String token) throws Exception;

    ClienteDTO updateCliente(String token, ClienteDTO clienteActualizado) throws Exception;
}
