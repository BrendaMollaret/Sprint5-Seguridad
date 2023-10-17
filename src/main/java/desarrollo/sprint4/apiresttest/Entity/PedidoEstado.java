package desarrollo.sprint4.apiresttest.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "pedido_estado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoEstado extends BaseEntity{
    @Column(name = "fecha_hora_alta_pedido_estado")
    private Date fechaHoraAltaPedidoEstado;
    @Column(name = "fecha_hora_baja_pedido_estado")
    private Date fechaHoraBajaPedidoEstado;
    @Column(name = "contador_pedido_estado")
    private Long contadorPedidoEstado;

    //Relations
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_estado_pedido")
    private EstadoPedido estadoPedido;
}
