package org.example.Sistema_Gestion_Transporte_Privado.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class tipoLicencia{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String nombre; // Ejemplo: "A", "B", "C", etc.
    private String descripcion;
}