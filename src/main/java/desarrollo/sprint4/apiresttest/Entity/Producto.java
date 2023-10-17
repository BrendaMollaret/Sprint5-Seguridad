package desarrollo.sprint4.apiresttest.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "producto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto extends BaseEntity{
    @Column(name = "nombre_prodcto")
    private String nombreProducto;
    @Column(name = "tiempo_estimado_cocina")
    private int tiempoEstimadoCocina;
    @Column(name = "precio_venta")
    private double precioVenta;
    @Column(name = "precio_compra")
    private double precioCompra;
    @Column(name = "stock_actual")
    private int stockActual;
    @Column(name = "stock_minimo")
    private int stockMinimo;
    @Column(name = "receta", length = 2000)
    private String receta;
    @Column(name = "fecha_hora_alta_producto")
    private Date fechaHoraAltaProducto;
    @Column(name = "fecha_hora_baja_producto")
    private Date fechaHoraBajaProducto;

    //Relations
    @ManyToOne
    @JoinColumn(name = "id_rubro")
    private Rubro rubro;

    @ManyToOne
    @JoinColumn(name = "id_unidad_medida")
    private UnidadMedida unidadMedida;

    @ManyToOne
    @JoinColumn(name = "id_tipo_producto")
    private TipoProducto tipoProducto;
}
