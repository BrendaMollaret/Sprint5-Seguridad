package desarrollo.sprint4.apiresttest.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
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
    private LocalDate fechaAltaProducto;

    @Column(name = "fecha_baja_rubro")
    private LocalDate fechaBajaProducto;

    @Column(name = "fecha_modificacion_rubro")
    private LocalDate fechaModificacionProducto;


    //Relaciones
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rubro_padre")
    @JsonBackReference // Usar esta anotación para evitar la recursión infinita al serializar
    private Rubro rubroPadre;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "rubroPadre", fetch = FetchType.EAGER)
    @Builder.Default
    @JsonManagedReference // Usar esta anotación para evitar la recursión infinita al serializar
    private List<Rubro> rubroHijoList = new ArrayList<>();

    public void agregarRubroHijo(Rubro rubro) {
        rubroHijoList.add(rubro);

    }

}
