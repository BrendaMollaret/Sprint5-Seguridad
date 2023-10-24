package desarrollo.sprint4.apiresttest.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "articulo_insumo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticuloInsumo extends BaseEntity{

    @Column(name = "fecha_hora_alta_articuloInsumo")
    private LocalDate fechaHoraAltaArticuloInsumo;

    @Column(name = "fecha_hora_modificacion_articuloinsumo")
    private LocalDate fechaHoraModificacionArticuloInsumo;

    @Column(name = "fecha_hora_baja_articuloinsumo")
    private LocalDate fechaHoraBajaArticuloInsumo;

    @Column(name = "nombreArticuloInsumo")
    private String nombreArticuloInsumo;

    @Column(name = "precio_compra")
    private BigDecimal precioCompra;

    @Column(name = "stockActual")
    private int stockActual;

    @Column(name = "stockMinimo")
    private int stockMinimo;

    @Column(name = "urlImagen")
    private String urlImagen;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_unidad_medida")
    private UnidadMedida unidadMedida;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rubro")
    private Rubro rubro;



}
