package desarrollo.sprint4.apiresttest.Service;

import desarrollo.sprint4.apiresttest.Entity.ArticuloInsumo;
import desarrollo.sprint4.apiresttest.Repository.ArticuloInsumoRepository;
import desarrollo.sprint4.apiresttest.Repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloInsumoServiceImpl extends BaseServiceImpl<ArticuloInsumo, Long> implements ArticuloInsumoService{

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;
    public ArticuloInsumoServiceImpl(BaseRepository<ArticuloInsumo, Long> baseRepository) {
        super(baseRepository);
        this.articuloInsumoRepository = articuloInsumoRepository;
    }
}
