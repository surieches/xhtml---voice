/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Profesor;

import BaseDeDatos.ProfesorBD;
import ProfesorBeans.Contenido;
import ProfesorBeans.Group;
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
public class RemoveContents extends ActionSupport implements SessionAware{
    private Map session;//la session
    List<Contenido> contents = new ArrayList<Contenido>();
    private String foo;
    
    @Override
    public String execute(){
        session = ActionContext.getContext().getSession();
        ProfesorBD p = new ProfesorBD();
        contents = p.ContenidosComplete(session.get("ID").toString());
        System.out.println(contents.size());
        return "SUCCESS";
    }

    
    public String RemoveRow() {
        session = ActionContext.getContext().getSession();
        System.out.println(foo);
        String[] f = foo.split(",");
        Contenido g = new Contenido();
        g.setID(f[0]);
        g.setNombre(f[1]);
        g.setPageContent(f[2]);
        g.setGrupoNombre(f[3]);
        g.setNivel(f[4]);
        ProfesorBD p = new ProfesorBD();
        if (p.DeleteContent(g, session.get("ID").toString())) {
            return "SUCCESS";
        } else {
            return "FAILURE";
        }
    }
    
    @Override
    public void setSession(Map map) {
        this.session=map;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public List<Contenido> getContents() {
        return contents;
    }

    
    
}
