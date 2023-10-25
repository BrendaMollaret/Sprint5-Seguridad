package desarrollo.sprint4.apiresttest.Repository;

import desarrollo.sprint4.apiresttest.Entity.Pedido;
import desarrollo.sprint4.apiresttest.Enumeration.EstadoPedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long> {

    //Para buscar el hitorial de pedidos relaizados por un cliente
    //Busco los pedidos y los ordeno desde el mas recente al mas antiguo
    @Query("SELECT p FROM Pedido p JOIN p.cliente c WHERE c.id = :idCliente ORDER BY p.fechaHoraPedido DESC")
    Page<Pedido> searchHistorialPedidoByCliente(
            @Param("idCliente") Long idCliente,
            Pageable pageable
    );


    //Para buscar los pedidos relacionados a un cliente dentro de un rango determinado
    //Para las fechas debo usar el formato YYYY-MM-DD (ej. 2023-01-01)
    @Query("SELECT p FROM Pedido p JOIN p.cliente c WHERE c.id = :idCliente AND p.fechaHoraPedido BETWEEN :fechaInicio AND :fechaFin ORDER BY p.fechaHoraPedido DESC") //ORDER BY p.fechaHoraPedido DESC
    Page<Pedido> searchPedidosByRangoFechasYCliente(
            @Param("idCliente") Long idCliente,
            @Param("fechaInicio") LocalDate fechaInicio,
            @Param("fechaFin") LocalDate fechaFin,
            Pageable pageable
    );

    //Para buscar pedidos con cierto estado
    @Query("SELECT p FROM Pedido p WHERE p.estadoPedido = :estadoPedido ORDER BY p.fechaHoraPedido DESC")
    Page<Pedido> searchByEstado(
            @Param("estadoPedido") EstadoPedido estadoPedido,
            Pageable pageable
    );


}
