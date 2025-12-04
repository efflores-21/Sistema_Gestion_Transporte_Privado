package org.example.Sistema_Gestion_Transporte_Privado.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.Required;
import org.openxava.annotations.Stereotype;

import javax.persistence.*;
import javax.ws.rs.DefaultValue;

@Entity
@Getter
@Setter
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Required
    private Reserva reserva;

    @ManyToOne(fetch = FetchType.LAZY)
    @Required
    private Conductor conductor;

    @Required @Column(length = 100)
    private String origen;

    @Required
    @Column(length = 100)
    private String destino;

    @Stereotype("MONEY")
    private Double distanciaKm;

    @Column(length = 20)
    @DefaultValue("Pendiente")
    private String estado = "Pendiente";
}
