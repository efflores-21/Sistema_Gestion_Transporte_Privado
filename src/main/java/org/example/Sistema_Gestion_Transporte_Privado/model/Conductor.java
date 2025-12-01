package org.example.Sistema_Gestion_Transporte_Privado.model;

import org.example.Sistema_Gestion_Transporte_Privado.Calculadora.BooleanTrueCalculator;
import org.example.Sistema_Gestion_Transporte_Privado.Tipos.TipoLicencia;
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DefaultValueCalculator;
import org.openxava.annotations.Required;
import org.openxava.annotations.Stereotype;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Conductor extends Persona{
    @Enumerated(EnumType.STRING)
    @Required
    private TipoLicencia tipoLicencia;

    @Stereotype("INTERGER")
    private  Integer aniosExperiencia;

    @DefaultValueCalculator(BooleanTrueCalculator.class)
    private Boolean disponible;
}
