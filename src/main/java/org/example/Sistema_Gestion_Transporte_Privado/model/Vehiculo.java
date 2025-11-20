package org.example.Sistema_Gestion_Transporte_Privado.model;

import groovy.transform.Sealed;
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.ReferenceView;
import org.openxava.annotations.Tab;
import org.openxava.annotations.View;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@View
@Tab
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
    @ReferenceView("Simple")
    private TipoVehiculo tipoVehiculo;


}
