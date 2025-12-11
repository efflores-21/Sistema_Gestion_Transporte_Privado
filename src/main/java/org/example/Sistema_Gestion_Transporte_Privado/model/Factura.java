package org.example.Sistema_Gestion_Transporte_Privado.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Factura extends Transaccion {

    @OneToOne(optional = false)
    @JoinColumn(name = "id_viaje")
    private Viaje viaje;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDate fechaEmision = LocalDate.now();

    @Column(name = "fecha_vencimiento", nullable = false)
    private LocalDate fechaVencimiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_pago", nullable = false)
    private EstadoPago estadoPago = EstadoPago.PENDIENTE;

    @Column(nullable = false)
    private Double impuestos;

    @OneToMany(mappedBy = "factura")
    private List<Pago> pagos = new ArrayList<>();

    public Factura() {}

    public Factura(Viaje viaje, Double monto, Double impuestos, LocalDate fechaVencimiento) {
        super(monto);
        this.viaje = viaje;
        this.impuestos = impuestos;
        this.fechaVencimiento = fechaVencimiento;
    }

    public boolean estaVencida() {
        return estadoPago == EstadoPago.PENDIENTE &&
                LocalDate.now().isAfter(fechaVencimiento);
    }
}
