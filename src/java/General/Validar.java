
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import BaseDeDatos.Login;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Maximus
 */
public class Validar extends ActionSupport implements SessionAware {

    private String Matricula;
    private String Password;
    private String Mensaje = "";
    private String Nombre = "";
    private Map session;

    @Override
    public String execute() {
        Login login = new Login();
        if (login.Validar(Matricula, Password)) {
            session = ActionContext.getContext().getSession();
            session.put("Tipo", login.getTipo());
            session.put("Nombre", login.getNombre());
            Nombre = login.getNombre();
            switch (login.getTipo()) {
                case 0:
                    return "ALUMNO";
                case 1:
                    return "PROFESOR";
                case 2:
                    return "ADMIN";
                default:
                    Mensaje = "Revise Password/Usuario";
                    return "FAILURE";
            }
        } else {
            Mensaje = "Revise Password/Usuario";
            return "FAILURE";
        }

    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    @Override
    public void setSession(Map map) {
        session = map;
    }

    public String getNombre() {
        return Nombre;
    }

    public String SessionOff() {
        return "exito";
    }
}
