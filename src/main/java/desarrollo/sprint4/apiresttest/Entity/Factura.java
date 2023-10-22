package desarrollo.sprint4.apiresttest.Entity;


import desarrollo.sprint4.apiresttest.Enumeration.FormaPago;
import desarrollo.sprint4.apiresttest.Enumeration.TipoFactura;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "factura")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura extends BaseEntity {

    @Column(name = "numero_factura")
    private int nroFactura;

    @Column(name = "fecha_hora_facturacion")
    private Date fechaHoraFacturacion;

    @Column(name = "fecha_modificacion_factura")
    private Date fechaModificacionFactura;

    @Column(name = "fecha_hora_baja_facturacion")
    private Date fechaHoraBajaFacturacion;

    @Column(name = "descuento")
    private BigDecimal descuento;

    @Column(name = "forma_pago")
    private FormaPago formaPago;

    @Column(name = "tipo_factura")
    private TipoFactura tipoFactura;

    @Column(name = "totalPrecioFactura")
    private BigDecimal totalPrecioFactura;


    //Relaciones
    @OneToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @OneToMany
    @JoinColumn(name = "id_detalle_pedido")
    private List<DetallePedido> detallePedidoList = new ArrayList<>();


}
