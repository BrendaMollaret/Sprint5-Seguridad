package desarrollo.sprint5.apiresttest.Repository;

import desarrollo.sprint5.apiresttest.Entity.Rubro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubroRepository extends BaseRepository<Rubro, Long>{


    //Buscar un rubro particular.
    @Query(
            value = "SELECT * FROM rubro WHERE rubro.nombre_rubro LIKE %:filtro%",
            nativeQuery = true
    )
    List<Rubro> searchByNombre(@Param("filtro") String filtro);
}
