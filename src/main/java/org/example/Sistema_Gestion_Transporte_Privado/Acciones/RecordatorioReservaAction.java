package org.example.Sistema_Gestion_Transporte_Privado.Acciones;

import org.example.Sistema_Gestion_Transporte_Privado.model.Reserva;
import org.example.Sistema_Gestion_Transporte_Privado.model.Cliente;
import org.openxava.actions.ViewBaseAction;
import org.openxava.jpa.XPersistence;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RecordatorioReservaAction extends ViewBaseAction {

    @Override
    public void execute() throws Exception {

        EntityManager em = XPersistence.getManager();

        Date hoy = truncarFecha(new Date());

        Query q = em.createQuery("from Reserva r where r.estado = 'Pendiente'");
        List<Reserva> reservas = q.getResultList();

        int enviados = 0;

        for (Reserva r : reservas) {

            Date fechaViaje = truncarFecha(r.getFechaViaje());

            long dias = calcularDiferenciaDias(hoy, fechaViaje);

            if (dias == 2) {
                Cliente cliente = r.getCliente();

                if (cliente != null && cliente.getEmail() != null) {

                    enviarCorreo(
                            cliente.getEmail(),
                            "Recordatorio de viaje",
                            "Estimado/a " + cliente.getNombre() + ":\n\n" +
                                    "Le recordamos que su viaje está programado para el día "
                                    + fechaViaje + ".\n\nGracias por confiar en nosotros."
                    );

                    enviados++;
                }
            }
        }

        addMessage("Recordatorios enviados: " + enviados);
    }

    private Date truncarFecha(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    private long calcularDiferenciaDias(Date inicio, Date fin) {
        long diffMillis = fin.getTime() - inicio.getTime();
        return diffMillis / (1000 * 60 * 60 * 24);
    }

    private void enviarCorreo(String destinatario, String asunto, String mensaje) {

        System.out.println("====================================");
        System.out.println("ENVIANDO CORREO");
        System.out.println("PARA: " + destinatario);
        System.out.println("ASUNTO: " + asunto);
        System.out.println("MENSAJE:\n" + mensaje);
        System.out.println("====================================");
    }
}
