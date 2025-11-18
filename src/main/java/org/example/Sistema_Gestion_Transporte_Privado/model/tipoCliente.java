package org.example.Sistema_Gestion_Transporte_Privado.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class tipoCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,unique = true)
    private String nombre; // Ejemplo: "Regular", "Premium", etc.
    private String descripcion;
    @OneToMany(mappedBy = "tipoCliente", cascade = CascadeType.ALL)
    private List<Cliente> clientes;
}
