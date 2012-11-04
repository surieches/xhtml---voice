/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Profesor;

import BaseDeDatos.ProfesorBD;
import ProfesorBeans.Calificaciones;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Maximus
 */
public class Qualifys extends ActionSupport implements SessionAware {

    List<Calificaciones> cals = new ArrayList<Calificaciones>();
    private Map session;//la session

    @Override
    public String execute() {
        session = ActionContext.getContext().getSession();
        ProfesorBD p = new ProfesorBD();
        cals = p.CalificacionesComplete(session.get("ID").toString());
        return "SUCCESS";
    }

    @Override
    public void setSession(Map map) {
        this.session = map;
    }

    public List<Calificaciones> getCals() {
        return cals;
    }
    
    
}
