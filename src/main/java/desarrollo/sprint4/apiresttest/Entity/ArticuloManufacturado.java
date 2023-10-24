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

    @Column(name = "descripcion_Articulo_Manufacturado")
    private String descripcionArticuloManufacturado;

    @Column(name = "nombre_Articulo_Manufacturado")
    private String nombreArticuloManufacturado;

    @Column(name = "precio_venta")
    private BigDecimal precioVenta;

    @Column(name = "tiempo_Estimado_Cocina")
    private int tiempoEstimadoCocina;

    @Column(name = "urlImagen_AM")
    private String urlImagen_AM;

    @Column(name = "fecha_Alta_Articulo_Manufacturado")
    private LocalDate fechaAltaArticuloManufacturado;

    @Column(name = "fecha_Modificacion_Articulo_Manufacturado")
    private LocalDate fechaModificacionArticuloManufacturado;

    @Column(name = "fecha_Baja_Articulo_Manufacturado")
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
