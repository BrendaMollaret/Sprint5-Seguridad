package desarrollo.sprint4.apiresttest.Repository;

import desarrollo.sprint4.apiresttest.Entity.ArticuloManufacturado;
import desarrollo.sprint4.apiresttest.Entity.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long> {

/*
    //Para buscar el hitorial de pedidos relaizados por un cliente
    @Query("SELECT p FROM Pedido p JOIN p.cliente c WHERE c.id = :idCliente ORDER BY p.fechaPedido DESC")
    Page<Pedido> searchHistorialPedidoByCliente(
            @Param("idCliente") Long idCliente,
            Pageable pageable
    );*/

}
