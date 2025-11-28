package org.example.Sistema_Gestion_Transporte_Privado.model;

import Tipos.TipoCliente;
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.ReferenceView;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Cliente extends BaseEntity{

    @Column(nullable = false)
    private String nombre;

    private String telefono;

    private String correoElectronico;

    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList(descriptionProperties = "nombre")
    @ReferenceView("Simple")
    private TipoCliente tipoCliente;

    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "cliente")
    private List<Viaje> viajes;
}
