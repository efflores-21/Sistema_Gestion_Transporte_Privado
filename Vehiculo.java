package org.example.Sistema_Gestion_Transporte_Privado.model;

import org.openxava.annotations.*;

import javax.persistence.*;

@Entity
@Table(name = "vehiculo", indexes = {
        @Index(columnList = "placa", name = "idx_vehiculo_placa")
})
@View(members =
        "placa, marca, modelo, anio, capacidad, estado;" +
                "tipo;" +
                "observaciones"
)
@Tab(properties = "id, placa, marca, modelo, anio, capacidad, estado, tipo.nombre")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20, unique = true)
    @Required
    private String placa;

    @Column(length = 60)
    private String marca;

    @Column(length = 60)
    private String modelo;

    private Integer anio;

    private Integer capacidad;

    @Column(length = 40)
    private String estado;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @DescriptionsList(descriptionProperties = "nombre, descripcion")
    private TipoVehiculo tipo;

    @Column(length = 500)
    @Stereotype("MEMO")
    private String observaciones;

    public Vehiculo() {}

    public Vehiculo(String placa, String marca, String modelo, Integer anio,
                    Integer capacidad, String estado, TipoVehiculo tipo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.capacidad = capacidad;
        this.estado = estado;
        this.tipo = tipo;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }

    public Integer getCapacidad() { return capacidad; }
    public void setCapacidad(Integer capacidad) { this.capacidad = capacidad; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public TipoVehiculo getTipo() { return tipo; }
    public void setTipo(TipoVehiculo tipo) { this.tipo = tipo; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    @Override
    public String toString() {
        return placa + " - " + marca + " " + modelo;
    }
}
