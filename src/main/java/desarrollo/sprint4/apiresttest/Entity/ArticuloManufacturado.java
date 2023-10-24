package desarrollo.sprint4.apiresttest.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "articulo_manufacturado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticuloManufacturado extends BaseEntity {

    @Column(name = "costo")
    private BigDecimal costo;

    @Column(name = "descripcion_articulo_manufacturado")
    private String descripcionArticuloManufacturado;

    @Column(name = "nombre_articulo_manufacturado")
    private String nombreArticuloManufacturado;

    @Column(name = "precio_venta")
    private BigDecimal precioVenta;

    @Column(name = "tiempo_estimado_cocina")
    private int tiempoEstimadoCocina;

    @Column(name = "url_imagen_am")
    private String urlImagen_AM;

    @Column(name = "fecha_alta_articulo_manufacturado")
    private LocalDate fechaAltaArticuloManufacturado;

    @Column(name = "fecha_modificacion_articulo_manufacturado")
    private LocalDate fechaModificacionArticuloManufacturado;

    @Column(name = "fecha_baja_articulo_manufacturado")
    private LocalDate fechaBajaArticuloManufacturado;


    //Relaciones

    @Builder.Default //Hice este cambio para que funcione
    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "articulo_manufacturado_id")
    private List<DetalleArticuloManufacturado> detalleArticuloManufacturadoList = new ArrayList<>();

    public void agregarDetalleArticuloManufacturado(DetalleArticuloManufacturado dam) {
        detalleArticuloManufacturadoList.add(dam);

    }
}
