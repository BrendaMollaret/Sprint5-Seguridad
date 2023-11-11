package desarrollo.sprint5.apiresttest.Service;

import desarrollo.sprint5.apiresttest.Entity.Localidad;
import desarrollo.sprint5.apiresttest.Repository.BaseRepository;
import desarrollo.sprint5.apiresttest.Repository.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalidadServiceImpl  extends BaseServiceImpl<Localidad, Long> implements LocalidadService {

    @Autowired
    private LocalidadRepository localidadRepository;

    public LocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Localidad searchById(Long idLocalidad) throws Exception {
        try {
            Localidad localidad = localidadRepository.searchById(idLocalidad);
            return localidad;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}