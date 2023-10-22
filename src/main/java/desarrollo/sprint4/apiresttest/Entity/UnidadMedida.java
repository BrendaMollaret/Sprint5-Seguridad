package desarrollo.sprint4.apiresttest.Entity;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "fecha_hora_alta_unidad_medida")
    private LocalDateTime fechaHoraAltaUnidadMedida;

    @Column(name = "fecha_hora__unidad_medida")
    private Date fechaHoraBajaUnidadMedida;

    @Column(name = "fecha_hora_modificacion_unidad_medida")
    private Date fechaHoraModificacionUnidadMedida;
}
