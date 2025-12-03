package org.example.Sistema_Gestion_Transporte_Privado.model;

import lombok.Getter;
import lombok.Setter;
import org.example.Sistema_Gestion_Transporte_Privado.Tipos.TipoVehiculo;
import org.openxava.annotations.Required;
import org.openxava.annotations.Stereotype;

import javax.persistence.*;
import javax.ws.rs.DefaultValue;

@Entity
@Getter
@Setter
public class Vehiculo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Required @Column(length = 10)
    private String placa;

    @Required @Column(length = 50)
    private String marca;

    @Required @Column(length = 50)
    private String modelo;

    @Stereotype("INTEGER")
    @Required
    private Integer capacidadPasajeros;

    @Enumerated(EnumType.STRING)
    @Required
    private TipoVehiculo tipoVehiculo;

    @Column(length = 20)
    @DefaultValue("Disponible")
    private String estado = "Disponible";
}
