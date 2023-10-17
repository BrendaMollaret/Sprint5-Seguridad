package desarrollo.sprint4.apiresttest.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "localidad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Localidad extends BaseEntity{
    @Column(name = "nombre_localidad")
    private String nombreLocalidad;
    @Column(name = "codigo_postal")
    private int codigoPostal;
}
