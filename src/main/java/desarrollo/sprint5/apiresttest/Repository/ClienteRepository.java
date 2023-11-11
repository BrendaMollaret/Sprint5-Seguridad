package desarrollo.sprint5.apiresttest.Repository;

import desarrollo.sprint5.apiresttest.Entity.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long>{

    //@Query(value = "SELECT c FROM Cliente c WHERE c.id = %:idCliente%")
    @Query(
            value = "SELECT * FROM Cliente WHERE id = %:idCliente%",
            nativeQuery = true
    )
    Cliente searchById(
            @Param("idCliente") Long idCliente
    );

}
