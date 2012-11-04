/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Profesor;

import BaseDeDatos.ProfesorBD;
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
public class RemoveGroup extends ActionSupport implements SessionAware{
    private Map session;//la session
    List<Group> grupos = new ArrayList<Group>();
    private String foo;
    
    @Override
    public String execute(){
        session = ActionContext.getContext().getSession();
        ProfesorBD p = new ProfesorBD();
        grupos = p.GruposComplete(session.get("ID").toString());
        return"SUCCESS";
    }

    public void RemoveRow(){
        session = ActionContext.getContext().getSession();
        System.out.println(foo);
        String[] f = foo.split(",");
        Group g = new Group();
        g.setID(f[0]);
        g.setNombre(f[1]);
        g.setNivel(f[2]);
        ProfesorBD p = new ProfesorBD();
        p.DeleteGroup(g, session.get("ID").toString());
    }
    
    @Override
    public void setSession(Map map) {
        this.session=map;
    }

    public List<Group> getGrupos() {
        return grupos;
    }

    

    public void setFoo(String foo) {
        this.foo = foo;
    }


    
    
}
