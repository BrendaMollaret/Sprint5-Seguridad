package desarrollo.sprint4.apiresttest.Service;

import desarrollo.sprint4.apiresttest.Entity.ArticuloManufacturado;
import desarrollo.sprint4.apiresttest.Repository.ArticuloManufacturadoRepository;
import desarrollo.sprint4.apiresttest.Repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado,Long> implements ArticuloManufacturadoService{

    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturado, Long> baseRepository, ArticuloManufacturadoRepository articuloManufacturadoRepository) {
        super(baseRepository);
    }

    @Override
    public Page<ArticuloManufacturado> searchByNombre(String filtro, Pageable pageable) throws Exception {
        try {

            Page<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.searchByNombre(filtro, pageable);

            return articuloManufacturados;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<ArticuloManufacturado> searchByPrecioVenta(BigDecimal precioVenta, Pageable pageable) throws Exception {
        try {

            Page<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.searchByPrecioVenta(precioVenta, pageable);

            return articuloManufacturados;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
