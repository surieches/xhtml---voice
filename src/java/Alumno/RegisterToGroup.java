/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Alumno;

import AlumnoBeans.GruposR;
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
public class RegisterToGroup extends ActionSupport implements SessionAware{
    private Map session;//la session
    private List<GruposR> grupos = new ArrayList<GruposR>();
    private String foo;
    
    @Override
    public String execute(){
        session = ActionContext.getContext().getSession();
        AlumnoBD al = new AlumnoBD();
        grupos = al.CalificacionesComplete();
        return "SUCCESS";
    }
    
    public String InscribirGrupo(){
        session = ActionContext.getContext().getSession();
        System.out.println(foo);
        String[] f = foo.split(",");
        GruposR g = new GruposR();
        g.setID(f[0]);
        g.setNombreGrupo(f[1]);
        g.setNivel(f[2]);
        g.setAppat(f[3]);
        g.setApmat(f[4]);
        g.setNombreProfesor(f[5]);
        AlumnoBD p = new AlumnoBD();
        if (p.InsertGroupAlumno(session.get("ID").toString(),g.getID())) {
            return "SUCCESS";
        } else {
            return "FAILURE";
        }
    }

    @Override
    public void setSession(Map map) {
        this.session=map;
    }

    public List<GruposR> getGrupos() {
        return grupos;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }
    
    
    
}
