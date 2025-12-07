package org.example.Sistema_Gestion_Transporte_Privado.Acciones;

import org.openxava.actions.SaveAction;
import org.openxava.jpa.XPersistence;

import javax.persistence.Query;

public class MiSaveUsuarioAction extends SaveAction {
    @Override
    public void execute() throws Exception {
        String username = getView().getValueString("username");
        String rol      = getView().getValueString("rol");

        Query q = XPersistence.getManager()
                .createQuery("select count(u) from Usuario u where u.username = :u");
        q.setParameter("u", username);
        Long count = (Long) q.getSingleResult();
        if (count > 0) {
            addError("user_exists");
            return;
        }

        super.execute(); // usa la lógica de create/modify de SaveAction
    }
}

