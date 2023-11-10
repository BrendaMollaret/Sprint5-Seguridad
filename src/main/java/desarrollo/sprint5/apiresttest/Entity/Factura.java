package desarrollo.sprint5.apiresttest.Entity;


import desarrollo.sprint5.apiresttest.Enumeration.FormaPago;
import desarrollo.sprint5.apiresttest.Enumeration.TipoFactura;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
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
    private LocalDate fechaHoraFacturacion;

    @Column(name = "fecha_modificacion_factura")
    private LocalDate fechaModificacionFactura;

    @Column(name = "fecha_hora_baja_facturacion")
    private LocalDate fechaHoraBajaFacturacion;

    @Column(name = "descuento")
    private BigDecimal descuento;

    @Column(name = "mp_merchant_order_id")
    private String mpMerchantOrderId;

    @Column(name = "mp_payment_id")
    private String mpPaymentId;

    @Column(name = "mp_payment_type")
    private String mpPaymentType;

    @Column(name = "mp_preference_id")
    private String mpPreferenceId;

    @Column(name = "totalPrecioFactura")
    private BigDecimal totalPrecioFactura;

    //Enumeration
    @Column(name = "forma_pago")
    private FormaPago formaPago;

    @Column(name = "tipo_factura")
    private TipoFactura tipoFactura;


    //Relaciones
    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @Builder.Default
    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_factura")
    private List<DetalleFactura> detalleFacturaList = new ArrayList<>();

    public void agregarDetalleFactura(DetalleFactura detalleFactura){
        detalleFacturaList.add(detalleFactura);
    }

}
