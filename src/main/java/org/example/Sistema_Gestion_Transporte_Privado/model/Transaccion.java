package org.example.Sistema_Gestion_Transporte_Privado.model;
import javax.persistence.*;
import org.openxava.annotations.*;

@MappedSuperclass
public abstract class Transaccion {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Required
    @Stereotype("DATETIME")
    private java.util.Date fechaRegistro = new java.util.Date();

    @Required
    @Stereotype("MONEY")
    private Double monto;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public java.util.Date getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(java.util.Date fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public Double getMonto() { return monto; }
    public void setMonto(Double monto) { this.monto = monto; }
}