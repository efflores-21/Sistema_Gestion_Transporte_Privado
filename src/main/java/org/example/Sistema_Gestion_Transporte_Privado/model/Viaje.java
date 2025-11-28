package org.example.Sistema_Gestion_Transporte_Privado.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DescriptionsList;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @ManyToOne
    @DescriptionsList(descriptionProperties = "nombreCompleto")
    private Conductor conductor;

    @ManyToOne
    @DescriptionsList(descriptionProperties = "placa")
    private Vehiculo vehiculo;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private double distanciaRecorrida; // en kilómetros

    private double tarifa; // costo del viaje

    private String estado; // Ejemplo: "En Progreso", "Completado", "Cancelado"
}
