package org.example.Sistema_Gestion_Transporte_Privado.Servicios;

import org.example.Sistema_Gestion_Transporte_Privado.model.Factura;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {

    // Configura aquí tu correo y app password de Gmail
    private final String remitente = "efflores@uamv.edu.ni";
    private final String clave = "kohm dklo ssld jgoq\n";

    public void enviarAvisoPago(String emailDestino, String nombre, Factura factura)
            throws MessagingException {

        // Validaciones iniciales
        if (remitente == null || remitente.trim().isEmpty()) {
            throw new IllegalStateException("No se ha configurado el remitente (GMAIL_USER)");
        }
        if (clave == null || clave.trim().isEmpty()) {
            throw new IllegalStateException("No se ha configurado la contraseña/app password (GMAIL_APP_PASSWORD)");
        }
        if (emailDestino == null || emailDestino.trim().isEmpty()) {
            throw new IllegalArgumentException("Email destino inválido");
        }
        if (factura == null) {
            throw new IllegalArgumentException("Factura requerida");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            nombre = "Cliente";
        }

        // Configuración del SMTP
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, clave);
            }
        });

        // Construcción del mensaje
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(remitente));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailDestino));
        msg.setSubject("🚨 Aviso de pago atrasado - Factura #" + factura.getId());

        // Validaciones null-safe de la factura
        String fechaVenc = factura.getFechaVencimiento() != null ? factura.getFechaVencimiento().toString() : "(sin fecha)";
        double montoTotal = (factura.getMonto() != null ? factura.getMonto() : 0.0) +
                (factura.getImpuestos() != null ? factura.getImpuestos() : 0.0);

        // Cuerpo del correo
        String cuerpo = String.format(
                "Hola %s,\n\n" +
                        "Su factura #%d está **VENCIDA** desde el %s.\n\n" +
                        "Detalles:\n" +
                        "Monto total: $%.2f USD\n" +
                        "Fecha vencimiento: %s\n\n" +
                        "Por favor regularice su pago a la brevedad.\n\n" +
                        "Atentamente,\n" +
                        "Sistema de Gestión de Transporte Privado\n" +
                        "support@tusistema.com",
                nombre,
                factura.getId(),
                fechaVenc,
                montoTotal,
                fechaVenc
        );

        msg.setText(cuerpo);
        Transport.send(msg);
    }
}