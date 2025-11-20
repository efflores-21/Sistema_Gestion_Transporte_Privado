package org.example.Sistema_Gestion_Transporte_Privado.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Conductor extends BaseEntity{
    @Column(nullable = false)
    private String nombreCompleto;
    @ManyToOne(fetch =  FetchType.LAZY)
    private tipoLicencia tipoLicencia;
    @Column(length = 50)
    private String telefono;


}
