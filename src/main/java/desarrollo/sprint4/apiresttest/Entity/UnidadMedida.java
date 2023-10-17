package desarrollo.sprint4.apiresttest.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @Column(name = "fecha_hora_baja_unidad_medida")
    private Date fechaHoraBajaUnidadMedida;
}
