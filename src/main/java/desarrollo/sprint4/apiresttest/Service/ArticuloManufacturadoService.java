package desarrollo.sprint4.apiresttest.Service;

import desarrollo.sprint4.apiresttest.Entity.ArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ArticuloManufacturadoService extends BaseService<ArticuloManufacturado, Long>{

    Page<ArticuloManufacturado> searchByNombre(String filtro, Pageable pageable) throws Exception;

    Page<ArticuloManufacturado> searchByPrecioVenta(BigDecimal precioVenta, Pageable pageable) throws Exception;

    Page<ArticuloManufacturado> searchByPrecioVentaRange(BigDecimal precioMinimo, BigDecimal precioMaximo, Pageable pageable) throws Exception;

    Page<ArticuloManufacturado> searchByCategoriaNombre(String nombreCategoria, Pageable pageable) throws Exception;

    List<ArticuloManufacturado> search(String filtro) throws Exception;
}
