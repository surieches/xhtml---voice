/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Alumno;

import BaseDeDatos.AlumnoBD;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Maximus
 */
public class Qualify extends ActionSupport implements SessionAware {

    private Map session;//la session
    private String Cal;
    private String ID;

    @Override
    public String execute() {
        session = ActionContext.getContext().getSession();
        AlumnoBD al = new AlumnoBD();
        System.out.println("El Alumno es "+session.get("ID").toString());
        System.out.println("El contenido es "+ID);
        System.out.println("La calificacion es "+Cal);
        if (al.InsertCalificacion(Cal, session.get("ID").toString(), ID)) {
            return "SUCCESS";
        } else {
            return "FAILURE";
        }
    }

    @Override
    public void setSession(Map map) {
        this.session = map;
    }

    public void setCal(String Cal) {
        this.Cal = Cal;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
