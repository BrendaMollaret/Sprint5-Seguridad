package desarrollo.sprint5.apiresttest.Service;

import desarrollo.sprint5.apiresttest.Entity.Rubro;
import desarrollo.sprint5.apiresttest.Repository.BaseRepository;
import desarrollo.sprint5.apiresttest.Repository.RubroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubroServiceImpl extends BaseServiceImpl<Rubro, Long> implements RubroService{

    @Autowired
    private RubroRepository rubroRepository;

    public RubroServiceImpl(BaseRepository<Rubro, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Rubro> searchByNombre(String filtro) throws Exception {
        try {
            List<Rubro> rubros = rubroRepository.searchByNombre(filtro);
            return rubros;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
