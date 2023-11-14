package desarrollo.sprint5.apiresttest.Service;

import desarrollo.sprint5.apiresttest.Entity.Domicilio;
import desarrollo.sprint5.apiresttest.Repository.BaseRepository;
import desarrollo.sprint5.apiresttest.Repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, Long> implements DomicilioService {

    @Autowired
    private DomicilioRepository domicilioRepository;

    public DomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository) {
        super(baseRepository);

    }

    @Override
    public boolean domicilioPerteneceAlCliente(Long idDomicilio, Long idCliente) throws Exception {
        try {
            boolean result = domicilioRepository.domicilioPerteneceAlCliente(idDomicilio, idCliente);
            return result;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
