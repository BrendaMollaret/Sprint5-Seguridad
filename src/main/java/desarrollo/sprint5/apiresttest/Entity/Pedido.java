package desarrollo.sprint5.apiresttest.Entity;

import desarrollo.sprint5.apiresttest.Enumeration.EstadoPedido;
import desarrollo.sprint5.apiresttest.Enumeration.FormaPago;
import desarrollo.sprint5.apiresttest.Enumeration.TipoEnvio;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
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
    private LocalDate fechaHoraPedido;

    @Column(name = "fecha_hora_modificacion_pedido")
    private LocalDate fechaHoraModificacionPedido;

    @Column(name = "fecha_hora_baja_pedido")
    private LocalDate fechaHoraBajaPedido;

    @Column(name = "fecha_hora_estimada_finalizacion")
    private LocalDate fechaHoraEstimadaFinalizacion;

    @Column(name = "total_precio")
    private double totalPrecio;

    @Column(name = "total_costo")
    private double totalCosto;

    //Enumeration

    @Column(name = "tipo_envio")
    private TipoEnvio tipoEnvio;

    @Column(name = "forma_pago")
    private FormaPago formaPago;

    @Column(name = "estado_pedido")
    private EstadoPedido estadoPedido;


    //Relaciones
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_domicilio_entrega")
    private Domicilio domicilioEntrega;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    @Builder.Default
    private List<DetallePedido> detallesPedido = new ArrayList<>();

    public void agregarDetallePedido(DetallePedido detallePed) {
        detallesPedido.add(detallePed);
    }

}
