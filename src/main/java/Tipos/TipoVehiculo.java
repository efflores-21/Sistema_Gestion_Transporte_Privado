package Tipos;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Getter
@Setter
public class TipoVehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nombreTipo; // Ejemplo: "Sedan", "SUV", "Camioneta", etc.

    private Integer capacidadPasajeros;
}
