package org.example.Sistema_Gestion_Transporte_Privado.model;

import Tipos.TipoVehiculo;
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.ReferenceView;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Vehiculo extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String placa;

    private String marca;

    private String modelo;

    @Column(name = "anio_fabricacion")
    private Integer anioFabricacion;

    @Column(name = "capacidad_pasajeros")
    private Integer capacidadPasajeros;

    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList(descriptionProperties = "nombreTipo")
    private TipoVehiculo tipoVehiculo;

    @OneToMany(mappedBy = "vehiculo")
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "vehiculo")
    private List<Viaje> viajes;
}
