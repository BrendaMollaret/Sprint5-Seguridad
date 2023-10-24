package desarrollo.sprint4.apiresttest.Service;

import desarrollo.sprint4.apiresttest.Entity.ArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface ArticuloManufacturadoService extends BaseService<ArticuloManufacturado, Long>{

    Page<ArticuloManufacturado> searchByNombre(String filtro, Pageable pageable) throws Exception;

    Page<ArticuloManufacturado> searchByPrecioVenta(BigDecimal precioVenta, Pageable pageable) throws Exception;


    /*Page<ArticuloManufacturado> findByCategoriaNombre(
            @Param("nombreCategoria") String nombreCategoria, Pageable pageable);

     */
}
