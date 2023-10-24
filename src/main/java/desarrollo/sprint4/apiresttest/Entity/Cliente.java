package desarrollo.sprint4.apiresttest.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente extends BaseEntity{

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido ;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "mail")
    private String mail;

    @Column(name = "fecha_hora_alta_cliente")
    private LocalDate fechaHoraAltaCliente;

    @Column(name = "fecha_hora_modificacion_cliente")
    private LocalDate fechaHoraModificacionCliente;

    @Column(name = "fecha_hora_baja_cliente")
    private LocalDate fechaHoraBajaCliente;

    //Relaciones
    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.EAGER)
    @Builder.Default
    @JoinColumn(name = "cliente_id")
    private List<Domicilio> domicilioList = new ArrayList<>();

    public void agregarDomicilio(Domicilio domi){
        domicilioList.add(domi);
    }

    //Agregué para mostrar los domicilios
    public void mostrarDomicilios(){
        System.out.println("\n Domicilios de: " + nombre + " " + apellido + " : ");
        for (Domicilio domicilio : domicilioList) {
            System.out.println("\nCalle: " + domicilio.getCalle() + "\nLocalidad: " + domicilio.getLocalidad() + "\nNumero: " + domicilio.getCalle() );
        }

    }
}
