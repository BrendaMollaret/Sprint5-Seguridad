package desarrollo.sprint5.apiresttest.Repository;

import desarrollo.sprint5.apiresttest.Entity.Factura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends BaseRepository<Factura, Long> {

    //Para buscar la factura relacionada a un Pedido
    @Query("SELECT f FROM Factura f JOIN f.pedido p WHERE p.id = :idPedido")
    Page<Factura> searchFacturaByPedido(
            @Param("idPedido") Long idPedido,
            Pageable pageable
    );

}
