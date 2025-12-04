package org.example.Sistema_Gestion_Transporte_Privado.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Required;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Proveedor extends Persona {
    @Required
    @Column(length = 100)
    private String tipoServicio; // Ej: "Mecánica", "Neumáticos"

}


