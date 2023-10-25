package desarrollo.sprint4.apiresttest.Repository;

import desarrollo.sprint4.apiresttest.Entity.ArticuloInsumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo,Long>{

    @Query(
            value = "SELECT * FROM articulo_insumo WHERE articulo_insumo.nombre_articulo_insumo LIKE %:nombre%",
            nativeQuery = true
    )
    Page<ArticuloInsumo> searchByNombre(
            @Param("nombre") String nombre,
            Pageable pageable
    );

    @Query(value = "SELECT ai FROM ArticuloInsumo ai JOIN ai.rubro r WHERE r.nombreRubro LIKE %:nombreRubro%")
    Page<ArticuloInsumo> searchByRubroNombre(
            @Param("nombreRubro") String nombreRubro,
            Pageable pageable
    );

}
