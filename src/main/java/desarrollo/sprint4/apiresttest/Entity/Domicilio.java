package desarrollo.sprint4.apiresttest.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "domicilio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Domicilio extends BaseEntity{
    @Column(name = "calle")
    private String calle;
    @Column(name = "numero_calle")
    private int nroCalle;
    @Column(name = "piso_dpto")
    private int pisoDpto;
    @Column(name = "numero_dpto")
    private int nroDpto;

    //Relations
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_localidad")
    private Localidad localidad;
}
