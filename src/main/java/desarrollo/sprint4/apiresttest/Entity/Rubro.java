package desarrollo.sprint4.apiresttest.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rubro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rubro extends BaseEntity {
    @Column(name = "nombre_rubro")
    private String nombreRubro;

    @Column(name = "fecha_alta_rubro")
    private Date fechaAltaProducto;

    @Column(name = "fecha_baja_rubro")
    private Date fechaBajaProducto;

    @Column(name = "fecha_modificacion_rubro")
    private Date fechaModificacionProducto;

    //Relaciones
    @ManyToOne
    @JoinColumn(name = "id_rubro_padre")
    private Rubro rubroPadre;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "rubro_id")
    @Builder.Default
    private List<Rubro> rubros = new ArrayList<>();

}
