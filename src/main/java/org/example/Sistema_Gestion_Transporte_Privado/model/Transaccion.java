package org.example.Sistema_Gestion_Transporte_Privado.model;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;


@MappedSuperclass
@Getter
@Setter
public abstract class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Long id;

    @Column(nullable = false)
    private Double monto;

    public Transaccion() {}

    public Transaccion(Double monto) {
        this.monto = monto;
    }

}