package org.example.Sistema_Gestion_Transporte_Privado.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.View;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@View(name="Simple", members="categoria")
public class tipoLicencia{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String nombre; // Ejemplo: "A", "B", "C", etc.
    private String descripcion;
    private LocalDate fechaVencimiento;
}