package org.example.Sistema_Gestion_Transporte_Privado.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DescriptionsList;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //@ManyToOne(fetch = FetchType.LAZY)
    //@DescriptionsList(descriptionProperties = "nombre")
    //private Cliente cliente;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@DescriptionsList(descriptionProperties = ("nombre")
    //private Vehiculo vehiculo;

    private LocalDate fechaSolicitud;
    private LocalDate fechaReserva;
    private Integer numeroPasajeros;
    private String estado; // Ejemplo: "Pendiente", "Confirmada", "Cancelada"

    //@OneToOne(mappedBy = "reserva")
    //private Viaje viaje;

}
