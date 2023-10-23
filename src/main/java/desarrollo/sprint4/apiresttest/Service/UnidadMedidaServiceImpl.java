package desarrollo.sprint4.apiresttest.Service;

import desarrollo.sprint4.apiresttest.Entity.Rubro;
import desarrollo.sprint4.apiresttest.Entity.UnidadMedida;
import desarrollo.sprint4.apiresttest.Repository.BaseRepository;
import desarrollo.sprint4.apiresttest.Repository.UnidadMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadMedidaServiceImpl extends BaseServiceImpl<UnidadMedida, Long> implements UnidadMedidaService{

    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    public UnidadMedidaServiceImpl(BaseRepository<UnidadMedida, Long> baseRepository) {
        super(baseRepository);
    }
}
