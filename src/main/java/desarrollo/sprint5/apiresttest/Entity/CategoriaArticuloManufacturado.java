package desarrollo.sprint5.apiresttest.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "categoria_articulo_manufacturado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaArticuloManufacturado extends BaseEntity {

    @Column(name = "cod_categoria_articulo_manufacturado")
    private int codCategoriaArticuloManufacturado;

    @Column(name = "nombre_categoria_articulo_manufacturado")
    private String nombreCategoriaArticuloManufacturado;

    @Column(name = "fecha_hora_alta_categoria_articulo_manufacturado")
    private LocalDate fechaHoraAltaCategoriaArticuloManufacturado;

    @Column(name = "fecha_hora_modificacion_categoria_articulo_manufacturado")
    private LocalDate fechaHoraModificacionCategoriaArticuloManufacturado;

    @Column(name = "fecha_hora_baja_categoria_articulo_manufacturado")
    private LocalDate fechaHoraBajaCategoriaArticuloManufacturado;

}
