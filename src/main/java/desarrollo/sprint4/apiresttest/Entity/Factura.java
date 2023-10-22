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

    @Column(name = "fecha_hora_facturacion")
    private Date fechaHoraFacturacion;

    @Column(name = "fecha_modificacion_factura")
    private Date fechaModificacionFactura;

    @Column(name = "fecha_hora_baja_facturacion")
    private Date fechaHoraBajaFacturacion;

    @Column(name = "descuento")
    private BigDecimal descuento;

    @Column(name = "mp_merchant_order_id")
    private BigDecimal mpMerchantOrderId;

    @Column(name = "mp_payment_id")
    private BigDecimal mpPaymentId;

    @Column(name = "mp_payment_type")
    private BigDecimal mpPaymentType;

    @Column(name = "mp_preference_id")
    private BigDecimal mpPreferenceId;

    @Column(name = "totalPrecioFactura")
    private BigDecimal totalPrecioFactura;

    //Enumeration
    @Column(name = "forma_pago")
    private FormaPago formaPago;

    @Column(name = "tipo_factura")
    private TipoFactura tipoFactura;


    //Relaciones
    @OneToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @OneToMany
    @JoinColumn(name = "id_detalle_factura")
    private List<DetallePedido> detallePedidoList = new ArrayList<>();


}
