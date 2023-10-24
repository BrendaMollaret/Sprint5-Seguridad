package desarrollo.sprint4.apiresttest.Repository;

import desarrollo.sprint4.apiresttest.Entity.ArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado,Long>{

    @Query(
            value = "SELECT * FROM articulo_manufacturado WHERE articulo_manufacturado.nombre_articulo_manufacturado LIKE %:filtro%",
            nativeQuery = true
    )
    Page<ArticuloManufacturado> searchByNombre(
            @Param("filtro") String filtro,
            Pageable pageable
    );

    @Query(
            value = "SELECT * FROM articulo_manufacturado WHERE articulo_manufacturado.precio_venta = :precioVenta",
            nativeQuery = true
    )
    Page<ArticuloManufacturado> searchByPrecioVenta(
            @Param("precioVenta") BigDecimal precioVenta,
            Pageable pageable
    );

}


