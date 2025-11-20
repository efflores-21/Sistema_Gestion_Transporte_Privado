package org.example.Sistema_Gestion_Transporte_Privado.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.View;

import javax.persistence.*;

@Entity
@Getter
@Setter
@View(name = "Simple", members = "nombreTipo")
public class TipoVehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String nombreTipo; // Ejemplo: "Sedan", "SUV", "Camioneta", etc.
    private Integer capacidadPasajeros;
}
