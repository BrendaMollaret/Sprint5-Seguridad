package desarrollo.sprint4.apiresttest.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "unidad_medida")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnidadMedida extends BaseEntity {

    @Column(name = "nombre_unidad_medida")
    private String nombreUnidadMedida;

    @Column(name = "abreviatura_unidad_medida")
    private String abrevitaturaUnidadMedida;

    @Column(name = "fecha_alta_unidad_medida")
    private LocalDate fechaAltaUnidadMedida;

    @Column(name = "fecha_unidad_medida")
    private Date fechaBajaUnidadMedida;

    @Column(name = "fecha_modificacion_unidad_medida")
    private Date fechaModificacionUnidadMedida;
}
