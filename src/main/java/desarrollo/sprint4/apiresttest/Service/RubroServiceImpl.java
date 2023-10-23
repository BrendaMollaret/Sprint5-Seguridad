package desarrollo.sprint4.apiresttest.Service;

import desarrollo.sprint4.apiresttest.Entity.Rubro;
import desarrollo.sprint4.apiresttest.Repository.BaseRepository;
import desarrollo.sprint4.apiresttest.Repository.RubroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubroServiceImpl extends BaseServiceImpl<Rubro, Long> implements RubroService{

    @Autowired
    private RubroRepository rubroRepository;

    public RubroServiceImpl(BaseRepository<Rubro, Long> baseRepository) {
        super(baseRepository);
    }
}
