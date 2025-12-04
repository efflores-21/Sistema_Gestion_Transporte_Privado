package org.example.Sistema_Gestion_Transporte_Privado.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Pago extends Transaccion {

    @ManyToOne
    @JoinColumn(name = "id_factura", nullable = false)
    private Factura factura;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pago", nullable = false)
    private MetodoPago metodoPago;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDate fechaPago;

    @Column
    private String referencia; // número de transacción, etc.

    // Constructor
    public Pago() {}

    public Pago(Factura factura, Double monto, MetodoPago metodoPago, String referencia) {
        super(monto);
        this.factura = factura;
        this.metodoPago = metodoPago;
        this.referencia = referencia;
        this.fechaPago = LocalDate.now();
    }

}
