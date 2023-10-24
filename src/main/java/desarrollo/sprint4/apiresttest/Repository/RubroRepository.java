package desarrollo.sprint4.apiresttest.Repository;

import desarrollo.sprint4.apiresttest.Entity.Rubro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubroRepository extends BaseRepository<Rubro, Long>{


    //Buscar un rubro particular
    @Query(
            value = "SELECT * FROM rubro WHERE rubro.nombre_rubro LIKE %:filtro%",
            nativeQuery = true
    )
    List<Rubro> search(@Param("filtro") String filtro);
}
