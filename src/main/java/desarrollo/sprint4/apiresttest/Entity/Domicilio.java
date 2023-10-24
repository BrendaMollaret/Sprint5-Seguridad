package desarrollo.sprint4.apiresttest.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

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

    @Column(name = "fecha_hora_alta_domicilio")
    private LocalDate fechaHoraAltaDomicilio;

    @Column(name = "fecha_hora_modificacion_domicilio")
    private LocalDate fechaHoraModificacionDomicilio;

    @Column(name = "fecha_hora_baja_domicilio")
    private LocalDate fechaHoraBajaDomicilio;

    //Relaciones

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_localidad")
    private Localidad localidad;
}
