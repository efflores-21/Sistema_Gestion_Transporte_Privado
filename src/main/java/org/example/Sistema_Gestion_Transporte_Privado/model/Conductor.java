package org.example.Sistema_Gestion_Transporte_Privado.model;

import Tipos.TipoLicencia;
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DescriptionsList;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Conductor extends BaseEntity{

    @Column(nullable = false)
    private String nombreCompleto;

    @ManyToOne(fetch =  FetchType.LAZY)
    @DescriptionsList(descriptionProperties = "nombre")
    private TipoLicencia tipoLicencia;

    @Column(length = 50)
    private String telefono;

    @OneToMany(mappedBy = "conductor")
    private List<Viaje> viajes;
}
