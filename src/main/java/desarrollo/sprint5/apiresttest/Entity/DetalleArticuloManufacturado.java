package desarrollo.sprint5.apiresttest.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "detalle_articulo_manufacturado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleArticuloManufacturado extends BaseEntity{

    @Column(name = "cantidad")
    private int cantidad;

    //Relaciones
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_articulo_insumo")
    private ArticuloInsumo articuloInsumo;

}
