package desarrollo.sprint4.apiresttest.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "estado_pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstadoPedido extends BaseEntity {
    @Column(name = "")
    private String codEstadoPedido;
    @Column(name = "nombre_estado_pedido")
    private String nombreEstadoPedido;

    //Relations
}
