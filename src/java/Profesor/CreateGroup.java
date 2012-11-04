/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Profesor;

import BaseDeDatos.ProfesorBD;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Maximus
 */
public class CreateGroup extends ActionSupport implements SessionAware {

    private Map session;//la session
    private String Nombre;//nombre del grupo
    private String Nivel;//Nivel del grupo

    @Override
    public String execute() {
        System.out.println("Se insertara un nuevo grupo");
        String ID = session.get("ID").toString();
        System.out.println(ID);
        System.out.println(Nombre);
        System.out.println(Nivel);
        ProfesorBD p = new ProfesorBD();
        if (p.InsertGrupo(Nombre, Nivel, ID)) {
            return "SUCCESS";
        } else {
            return "FAILURE";
        }
    }

    @Override
    public void setSession(Map map) {
        this.session = map;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setNivel(String Nivel) {
        this.Nivel = Nivel;
    }
}
