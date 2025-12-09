package org.example.Sistema_Gestion_Transporte_Privado.Acciones;

import com.openxava.naviox.actions.ForwardToOriginalURIBaseAction;
import com.openxava.naviox.impl.SignInHelper;
import org.example.Sistema_Gestion_Transporte_Privado.model.Usuario;
import org.openxava.util.Is;
import org.openxava.jpa.XPersistence;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Logger;


public class SignInAction extends ForwardToOriginalURIBaseAction {
    private static final Logger LOG = Logger.getLogger(SignInAction.class.getName());

    @Override
    public void execute() throws Exception {

        if (getRequest() == null || getView() == null) {
            addError("internal_error");
            return;
        }

        String userName = getView().getValueString("username");
        if (Is.emptyString(userName))
            userName = getView().getValueString("user");

        String password = getView().getValueString("password");

        if (Is.emptyString(userName, password)) {
            addError("unauthorized_user");
            return;
        }

        EntityManager em = XPersistence.getManager();

        Query q = em.createQuery(
                "from Usuario u where u.username = :username and u.password = :password"
        );
        q.setParameter("username", userName);
        q.setParameter("password", password);

        List<Usuario> lista = q.getResultList();

        if (lista.isEmpty()) {
            addError("unauthorized_user");
            return;
        }

        Usuario usuario = lista.get(0);

        // Guardar datos en sesión
        HttpSession session = getRequest().getSession();
        session.setAttribute("username", usuario.getUsername());
        session.setAttribute("rol", usuario.getRol());

        SignInHelper.signIn(getRequest(), userName);

        getView().reset();
        getContext().resetAllModulesExceptCurrent(getRequest());
        forwardToOriginalURI();
    }
}