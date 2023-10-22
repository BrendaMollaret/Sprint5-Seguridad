package desarrollo.sprint4.apiresttest.Entity;

import desarrollo.sprint4.apiresttest.Enumeration.EstadoPedido;
import desarrollo.sprint4.apiresttest.Enumeration.FormaPago;
import desarrollo.sprint4.apiresttest.Enumeration.TipoEnvio;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido extends BaseEntity {

    @Column(name = "fecha_hora_pedido")
    private Date fechaHoraPedido;

    @Column(name = "fecha_hora_modificacion_pedido")
    private Date fechaHoraModificacionPedido;

    @Column(name = "fecha_hora_baja_pedido")
    private Date fechaHoraBajaPedido;

    @Column(name = "fecha_hora_estimada_finalizacion")
    private Date fechaHoraEstimadaFinalizacion;

    @Column(name = "total_precio")
    private double totalPrecio;

    @Column(name = "tipo_envio")
    private TipoEnvio tipoEnvio;

    @Column(name = "forma_pago")
    private FormaPago formaPago;

    @Column(name = "estado_pedido")
    private EstadoPedido estadoPedido;


    //Relaciones
    @ManyToOne
    @JoinColumn(name = "id_domicilio_entrega")
    private Domicilio domicilioEntrega;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    @Builder.Default
    private List<DetallePedido> detallesPedido = new ArrayList<>();

    public void agregarDetallePedido(DetallePedido detallePed) {
        detallesPedido.add(detallePed);
    }

}
