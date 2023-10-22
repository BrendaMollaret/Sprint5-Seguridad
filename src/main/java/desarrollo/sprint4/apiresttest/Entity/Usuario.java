package desarrollo.sprint4.apiresttest.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario extends BaseEntity{

    @Column(name = "fecha_alta_usuario")
    private Date fechaAltaUsuario;

    @Column(name = "fecha_baja_usuario")
    private Date fechaBajaUsuario;

    @Column(name = "fecha_modificacion_usuario")
    private Date fechaModificacionUsuario;

    @Column(name = "username")
    private String username;
}
