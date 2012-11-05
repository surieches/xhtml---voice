/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Alumno;

import AlumnoBeans.CalificacionesA;
import BaseDeDatos.AlumnoBD;
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
public class CalificacionesVer extends ActionSupport implements SessionAware{
    private Map session;//la session
    private List<CalificacionesA> cals = new ArrayList<CalificacionesA>();
    
    @Override
    public String execute(){
        session = ActionContext.getContext().getSession();
        AlumnoBD al = new AlumnoBD();
        cals = al.CalificacionesCompleteAlumno(session.get("ID").toString());
        return "SUCCESS";
    }

    @Override
    public void setSession(Map map) {
        this.session= map;
    }

    public List<CalificacionesA> getCals() {
        return cals;
    }
    
    
    
    
}
