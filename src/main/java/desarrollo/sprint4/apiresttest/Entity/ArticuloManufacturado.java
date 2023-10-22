package desarrollo.sprint4.apiresttest.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "articulo_manufacturado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticuloManufacturado extends BaseEntity{

    @Column(name = "costo")
    private BigDecimal costo;

    @Column(name = "descripcionArticuloManufacturado")
    private String descripcionArticuloManufacturado;

    @Column(name = "nombreArticuloManufacturado")
    private String nombreArticuloManufacturado;

    @Column(name = "precioVenta")
    private BigDecimal precioVenta;

    @Column(name = "tiempoEstimadoCocina")
    private int tiempoEstimadoCocina;

    @Column(name = "urlImagen_AM")
    private String urlImagen_AM;
}
