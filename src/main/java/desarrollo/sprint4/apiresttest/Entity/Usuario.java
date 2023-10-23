package desarrollo.sprint4.apiresttest.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
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
    private LocalDate fechaAltaUsuario;

    @Column(name = "fecha_baja_usuario")
    private LocalDate fechaBajaUsuario;

    @Column(name = "fecha_modificacion_usuario")
    private LocalDate fechaModificacionUsuario;

    @Column(name = "username")
    private String username;

    @Column(name = "auth0Id")
    private String auth0Id;


}
