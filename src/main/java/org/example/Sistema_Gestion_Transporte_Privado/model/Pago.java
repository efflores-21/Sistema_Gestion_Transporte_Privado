package org.example.Sistema_Gestion_Transporte_Privado.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@View(members = "factura, monto, metodoPago, referencia, fechaPago")
@Getter @Setter
public class Pago extends Transaccion {

    @ManyToOne(fetch = FetchType.LAZY)
    @Required
    private Factura factura;

    @Stereotype("TEXT")
    @Required
    private String metodoPago;

    @Stereotype("TEXT")
    private String referencia;

    @Stereotype("DATE")
    @Required
    private Date fechaPago = new Date();
}
