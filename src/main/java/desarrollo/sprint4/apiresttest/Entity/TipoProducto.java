package desarrollo.sprint4.apiresttest.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipo_producto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoProducto extends BaseEntity {
    @Column(name = "cod_tipo_producto")
    private String codTipoProducto;
    @Column(name = "nombre_tipo_producto")
    private String nombreTipoProducto;
}
