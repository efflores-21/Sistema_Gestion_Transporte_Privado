package org.example.Sistema_Gestion_Transporte_Privado.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class Factura extends Transaccion {

    @OneToOne
    @JoinColumn(name = "id_viaje", nullable = false)
    private Viaje viaje;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDate fechaEmision;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_pago", nullable = false)
    private EstadoPago estadoPago = EstadoPago.PENDIENTE;

    @Column(nullable = false)
    private Double impuestos;

    // Constructor
    public Factura() {}

    public Factura(Viaje viaje, Double monto, Double impuestos) {
        super(monto);
        this.viaje = viaje;
        this.impuestos = impuestos;
        this.fechaEmision = LocalDate.now();
    }
}
