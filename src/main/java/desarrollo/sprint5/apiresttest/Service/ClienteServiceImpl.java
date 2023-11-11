package desarrollo.sprint5.apiresttest.Service;

import desarrollo.sprint5.apiresttest.Entity.Cliente;
import desarrollo.sprint5.apiresttest.Repository.BaseRepository;
import desarrollo.sprint5.apiresttest.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente,Long> implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Cliente searchById(Long idCliente) throws Exception {
        try {
            Cliente cliente = clienteRepository.searchById(idCliente);
            return cliente;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
