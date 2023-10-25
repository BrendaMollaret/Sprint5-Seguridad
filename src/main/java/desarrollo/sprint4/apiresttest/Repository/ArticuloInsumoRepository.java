package desarrollo.sprint4.apiresttest.Repository;

import desarrollo.sprint4.apiresttest.Entity.ArticuloInsumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo,Long>{

    @Query (
            value = "SELECT * FROM articuloInsumo WHERE articuloInsumo.nombreArticuloInsumo LIKE %:filtro% ",
            nativeQuery = true
    )
    List<ArticuloInsumo> searchNativo(@Param("filtro") String filtro);


    //buscar articulo insumo por su nombre
    @Query(
            value = "SELECT * FROM articulo_insumo WHERE articulo_insumo.nombre_articulo_insumo LIKE %:nombre%",
            nativeQuery = true
    )
    Page<ArticuloInsumo> searchByNombre(
            @Param("nombre") String nombre,
            Pageable pageable
    );

    //buscar un articulo insumo por su rubro
    @Query(value = "SELECT ai FROM ArticuloInsumo ai JOIN ai.rubro r WHERE r.nombreRubro LIKE %:nombreRubro%")
    Page<ArticuloInsumo> searchByRubroNombre(
            @Param("nombreRubro") String nombreRubro,
            Pageable pageable
    );


}
