package org.example.Sistema_Gestion_Transporte_Privado.model;

import org.openxava.annotations.*;

import javax.persistence.*;

@Entity
@Table(name = "tipo_vehiculo")
@View(members = "nombre; descripcion")
@Tab(properties = "id, nombre, descripcion")
public class TipoVehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60, unique = true)
    @Required
    private String nombre;

    @Column(length = 200)
    private String descripcion;

    public TipoVehiculo() {}

    public TipoVehiculo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters / Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    @Override
    public String toString() {
        return nombre;
    }
}
