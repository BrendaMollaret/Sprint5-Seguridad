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
public class DetalleArticuloManufacturado extends BaseEntity{

    @Column(name = "cantidad")
    private int cantidad;

    //Relaciones
    @ManyToOne
    @JoinColumn(name = "id_articulo_insumo")
    private ArticuloInsumo articuloInsumo;

}
