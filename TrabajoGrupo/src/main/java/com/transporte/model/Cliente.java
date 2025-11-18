package com.transporte.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String telefono;
    private String correo;
    private String tipoCliente;

    // Constructor vacío requerido por JPA
    public Cliente() {}

    public Cliente(String nombre, String telefono, String correo, String tipoCliente) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.tipoCliente = tipoCliente;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTipoCliente() { return tipoCliente; }
    public void setTipoCliente(String tipoCliente) { this.tipoCliente = tipoCliente; }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", tipoCliente='" + tipoCliente + '\'' +
                '}';
    }
}
