package com.transporte.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.io.Serializable;

@Entity
public class Conductor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String licencia;
    private String categoriaLicencia;
    private LocalDate fechaVencimiento;
    private int aniosExperiencia;
    private String telefono;

    public Conductor() {}

    public Conductor(String nombre, String licencia, String categoriaLicencia,
                     LocalDate fechaVencimiento, int aniosExperiencia, String telefono) {
        this.nombre = nombre;
        this.licencia = licencia;
        this.categoriaLicencia = categoriaLicencia;
        this.fechaVencimiento = fechaVencimiento;
        this.aniosExperiencia = aniosExperiencia;
        this.telefono = telefono;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getLicencia() { return licencia; }
    public void setLicencia(String licencia) { this.licencia = licencia; }

    public String getCategoriaLicencia() { return categoriaLicencia; }
    public void setCategoriaLicencia(String categoriaLicencia) { this.categoriaLicencia = categoriaLicencia; }

    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public int getAniosExperiencia() { return aniosExperiencia; }
    public void setAniosExperiencia(int aniosExperiencia) { this.aniosExperiencia = aniosExperiencia; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    @Override
    public String toString() {
        return "Conductor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", licencia='" + licencia + '\'' +
                ", categoriaLicencia='" + categoriaLicencia + '\'' +
                ", fechaVencimiento=" + fechaVencimiento +
                ", aniosExperiencia=" + aniosExperiencia +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
