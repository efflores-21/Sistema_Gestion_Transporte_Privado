package org.example.Sistema_Gestion_Transporte_Privado.Acciones;

import org.example.Sistema_Gestion_Transporte_Privado.Servicios.EmailService;
import org.example.Sistema_Gestion_Transporte_Privado.model.Cliente;
import org.example.Sistema_Gestion_Transporte_Privado.model.Factura;
import org.example.Sistema_Gestion_Transporte_Privado.model.Reserva;
import org.example.Sistema_Gestion_Transporte_Privado.model.Viaje;
import org.openxava.actions.ViewBaseAction;

public class EnviarAvisoPagoAction extends ViewBaseAction {

    @Override
    public void execute() throws Exception {

        Factura factura = (Factura) getView().getEntity();
        if (factura == null) {
            addError("Abra una factura en vista DETALLE");
            return;
        }

        // Validaciones de relaciones
        Viaje viaje = factura.getViaje();
        if (viaje == null) {
            addError("La factura no tiene viaje asignado");
            return;
        }

        Reserva reserva = viaje.getReserva();
        if (reserva == null) {
            addError("El viaje no tiene reserva asignada");
            return;
        }

        Cliente cliente = reserva.getCliente();
        if (cliente == null) {
            addError("La reserva no tiene cliente asignado");
            return;
        }

        // Validación del email
        String emailCliente = cliente.getEmail();
        if (emailCliente == null || emailCliente.trim().isEmpty()) {
            addError("El cliente " + (cliente.getNombre() != null ? cliente.getNombre() : "") + " no tiene email configurado");
            return;
        }

        String nombreCliente = cliente.getNombre() != null ? cliente.getNombre() : "Cliente";

        try {
            EmailService emailService = new EmailService();
            emailService.enviarAvisoPago(emailCliente, nombreCliente, factura);
            addMessage("✅ Correo enviado correctamente a " + emailCliente);
        } catch (Exception e) {
            addError("Error enviando correo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
