package desarrollo.sprint4.apiresttest.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "detalle_pedido_manufacturado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleProductoManufacturado extends BaseEntity{
    @Column(name = "cantidad")
    private int cantidad;

    //Relations
    @ManyToOne
    @JoinColumn(name = "id_producto_insumo")
    private Producto productoInsumo;

    @ManyToOne
    @JoinColumn(name = "id_producto_manufacturado")
    private Producto productoManufacturado;

}
