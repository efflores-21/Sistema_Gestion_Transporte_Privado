package org.example.Sistema_Gestion_Transporte_Privado.model;

import org.example.Sistema_Gestion_Transporte_Privado.Tipos.TipoCliente;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Cliente extends Persona{
    @Enumerated(EnumType.STRING)
    @Required
    private TipoCliente tipoCliente;
}
