package org.example.Sistema_Gestion_Transporte_Privado.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.ReferenceView;
import org.openxava.annotations.Tab;
import org.openxava.annotations.View;

import javax.persistence.*;

@Entity
@Getter
@Setter
@View(members = "nombre, telefono, correoElectronico; tipoCliente")
@Tab(properties = "nombre, tipoCliente.nombre, telefono, correoElectronico")
public class Cliente extends BaseEntity{
    @Column(nullable = false)
    private String nombre;
    private String telefono;
    private String correoElectronico;
    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList(descriptionProperties = "nombre")
    @ReferenceView("Simple")
    private tipoCliente tipoCliente;

}
