/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Alumno;

import AlumnoBeans.ContenidosVer;
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
public class Contenidos extends ActionSupport implements SessionAware {

    private Map session;//la session
    private List<ContenidosVer> contents = new ArrayList<ContenidosVer>();

    @Override
    public String execute() {
        session = ActionContext.getContext().getSession();
        AlumnoBD al = new AlumnoBD();
        contents = al.ContenidosComplete(session.get("ID").toString());
        return "SUCCESS";
    }

    @Override
    public void setSession(Map map) {
        this.session = map;
    }

    public List<ContenidosVer> getContents() {
        return contents;
    }
    
}
