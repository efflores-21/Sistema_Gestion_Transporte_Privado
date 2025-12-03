package org.example.Sistema_Gestion_Transporte_Privado.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.Required;
import org.openxava.annotations.Stereotype;

import javax.persistence.*;
import javax.ws.rs.DefaultValue;

@Entity
@Getter
@Setter
public class Reserva {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Required
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @Required
    private Vehiculo vehiculo;

    @Stereotype("DATETIME")
    @Required
    private java.util.Date fechaViaje;

    @Stereotype("INTEGER")
    @Required
    private Integer numeroPasajeros;

    @Stereotype("MONEY")
    @Required
    private Double costo;

    @Column(length = 20)
    @DefaultValue("Pendiente")
    private String estado = "Pendiente";

}
