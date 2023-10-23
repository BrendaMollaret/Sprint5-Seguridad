package desarrollo.sprint4.apiresttest.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

public class DetalleFactura extends BaseEntity{

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "subtotal")
    private BigDecimal subTotal;

    //Relations
    @ManyToOne
    @Column(name = "id_articuloManufacturado")
    private ArticuloManufacturado articuloManufacturado;

    @ManyToOne
    @Column(name = "id_articuloInsumo")
    private ArticuloInsumo articuloInsumo;

}
