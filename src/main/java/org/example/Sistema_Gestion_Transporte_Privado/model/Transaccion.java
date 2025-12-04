package org.example.Sistema_Gestion_Transporte_Privado.model;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    protected Integer id;

    @Column(name = "fecha_registro", nullable = false)
    protected LocalDateTime fechaRegistro = LocalDateTime.now();

    @Column(nullable = false)
    protected Double monto;

    public Transaccion() {}

    public Transaccion(Double monto) {
        this.monto = monto;
    }

}