package desarrollo.sprint5.apiresttest.Repository;

import desarrollo.sprint5.apiresttest.Entity.Localidad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadRepository extends BaseRepository<Localidad, Long> {

    //Buscar Localidad por Id
    @Query(
            value = "SELECT * FROM Localidad WHERE id = %:idLocalidad%",
            nativeQuery = true
    )
    Localidad searchById(
            @Param("idLocalidad") Long idLocalidad
    );
}
