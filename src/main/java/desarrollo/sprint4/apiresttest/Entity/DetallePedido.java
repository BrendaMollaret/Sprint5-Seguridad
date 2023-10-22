package desarrollo.sprint4.apiresttest.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetallePedido extends BaseEntity{

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "subtotal")
    private BigDecimal subtotal;

    private BigDecimal subTotalCosto;

    //Relations
    @ManyToOne
    @JoinColumn(name = "id_articulo_manufacturado")
    private ArticuloManufacturado articuloManufacturado;

    @ManyToOne
    @JoinColumn(name = "id_articulo_insumo")
    private ArticuloInsumo articuloInsumo;
}
