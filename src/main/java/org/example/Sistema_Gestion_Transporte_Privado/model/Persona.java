package org.example.Sistema_Gestion_Transporte_Privado.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public abstract class Persona {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Required @Column(length = 100)
    private String nombre;

    @Required @Column(length = 100)
    private String telefono;

    @Column(length = 100)
    private String email;
}
