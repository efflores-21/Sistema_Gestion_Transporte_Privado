package org.example.Sistema_Gestion_Transporte_Privado.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nombre;
    private String telefono;
    private String correoElectronico;
    @ManyToOne(fetch = FetchType.LAZY)
    private tipoCliente tipoCliente;

}
