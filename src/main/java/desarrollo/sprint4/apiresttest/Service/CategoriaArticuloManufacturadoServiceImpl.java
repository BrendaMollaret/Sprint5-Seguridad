package desarrollo.sprint4.apiresttest.Service;

import desarrollo.sprint4.apiresttest.Entity.CategoriaArticuloManufacturado;
import desarrollo.sprint4.apiresttest.Repository.BaseRepository;
import desarrollo.sprint4.apiresttest.Repository.CategoriaArticuloManufacturadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaArticuloManufacturadoServiceImpl extends BaseServiceImpl<CategoriaArticuloManufacturado,Long> implements CategoriaArticuloManufacturadoService{

    @Autowired
    private CategoriaArticuloManufacturadoRepository categoriaArticuloManufacturadoRepository;

    public CategoriaArticuloManufacturadoServiceImpl(BaseRepository<CategoriaArticuloManufacturado, Long> baseRepository) {
        super(baseRepository);
    }
}
