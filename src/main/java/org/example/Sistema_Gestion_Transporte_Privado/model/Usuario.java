package org.example.Sistema_Gestion_Transporte_Privado.model;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Usuario  extends Persona {
    private String username;
    private String password;
    private String rol;
}
