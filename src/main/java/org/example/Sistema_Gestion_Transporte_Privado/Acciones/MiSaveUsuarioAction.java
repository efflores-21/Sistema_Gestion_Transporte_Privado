package org.example.Sistema_Gestion_Transporte_Privado.Acciones;

import org.openxava.actions.SaveAction;
import org.openxava.util.Is;
import org.openxava.jpa.XPersistence;

import javax.persistence.Query;
import javax.persistence.EntityManager;

public class MiSaveUsuarioAction extends SaveAction {

    @Override
    public void execute() throws Exception {
        String method = getRequest() != null ? getRequest().getMethod() : "GET";
        // Si es GET delegar al comportamiento por defecto para no romper la carga inicial
        if ("GET".equalsIgnoreCase(method)) {
            super.execute();
            return;
        }

        String username = getView().getValueString("username");
        if (Is.emptyString(username)) {
            username = getView().getValueString("user");
        }
        if (Is.emptyString(username)) {
            addError("user_required");
            return;
        }
        username = username.trim();

        EntityManager em = XPersistence.getManager();
        Query q = em.createQuery("select count(u) from Usuario u where u.username = :u");
        q.setParameter("u", username);
        Long count = (Long) q.getSingleResult();
        if (count > 0) {
            addError("user_exists");
            return;
        }

        super.execute();
    }
}
