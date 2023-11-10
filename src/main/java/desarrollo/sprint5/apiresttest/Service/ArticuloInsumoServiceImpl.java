package desarrollo.sprint5.apiresttest.Service;

import desarrollo.sprint5.apiresttest.Entity.ArticuloInsumo;
import desarrollo.sprint5.apiresttest.Repository.ArticuloInsumoRepository;
import desarrollo.sprint5.apiresttest.Repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArticuloInsumoServiceImpl extends BaseServiceImpl<ArticuloInsumo, Long> implements ArticuloInsumoService{

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;
    public ArticuloInsumoServiceImpl(BaseRepository<ArticuloInsumo, Long> baseRepository) {
        super(baseRepository);
        this.articuloInsumoRepository = articuloInsumoRepository;
    }

    @Override
    public Page<ArticuloInsumo> searchByNombre(String nombre, Pageable pageable) throws Exception {
        try {

            Page<ArticuloInsumo> articuloInsumos = articuloInsumoRepository.searchByNombre(nombre, pageable);

            return articuloInsumos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<ArticuloInsumo> searchByRubroNombre(String nombreRubro, Pageable pageable) throws Exception {
        try {

            Page<ArticuloInsumo> articuloInsumos = articuloInsumoRepository.searchByRubroNombre(nombreRubro, pageable);

            return articuloInsumos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
