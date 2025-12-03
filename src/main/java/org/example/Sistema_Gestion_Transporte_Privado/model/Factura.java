package org.example.Sistema_Gestion_Transporte_Privado.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import javax.persistence.*;
import javax.ws.rs.DefaultValue;
import java.util.Date;

@Entity
@View(members = "viaje, monto, impuestos, estadoPago, fechaEmision")
@Getter @Setter
public class Factura extends Transaccion {

    @ManyToOne(fetch = FetchType.LAZY)
    @Required
    private Viaje viaje;

    @Stereotype("MONEY")
    @Required
    private Double impuestos;

    @Stereotype("ENUMERATION")
    @Required
    @DefaultValue("PENDIENTE")
    private String estadoPago;

    @Stereotype("DATE")
    @ReadOnly
    private Date fechaEmision = new Date();

    public Double getTotal() {
        return getMonto() + impuestos;
    }
}
