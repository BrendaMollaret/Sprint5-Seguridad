package desarrollo.sprint5.apiresttest.Service;

import desarrollo.sprint5.apiresttest.Entity.ArticuloManufacturado;
import desarrollo.sprint5.apiresttest.Repository.ArticuloManufacturadoRepository;
import desarrollo.sprint5.apiresttest.Repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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

    @Override
    public Page<ArticuloManufacturado> searchByPrecioVentaRange(BigDecimal precioMinimo, BigDecimal precioMaximo, Pageable pageable) throws Exception {
        try {

            Page<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.searchByPrecioVentaRange(precioMinimo, precioMaximo, pageable);

            return articuloManufacturados;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<ArticuloManufacturado> searchByCategoriaNombre(String nombreCategoria, Pageable pageable) throws Exception {
        try {

            Page<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.searchByCategoriaNombre(nombreCategoria, pageable);

            return articuloManufacturados;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ArticuloManufacturado> search(String filtro) throws Exception {
        try {
            List<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.search(filtro);
            return articuloManufacturados;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
