package desarrollo.sprint4.apiresttest.Entity;

import Spring3.ElBuenSabor.enumeration.FormaPago;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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
    @Column(name = "descuento")
    private double descuento;
    @Column(name = "forma_pago")
    private FormaPago formaPago;
    @Column(name = "totalPrecioFactura")
    private double totalPrecioFactura;

    //Relations
    @OneToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
}
