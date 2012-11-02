/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministradorControl;

/**
 *
 * @author IPNWIN
 */
import BaseDeDatos.Elimina;
import BaseDeDatos.Login;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Maximus
 */
public class Eliminar extends ActionSupport {

    private String Mensaje = "";
    private String Nombre = "";

    @Override
    public String execute() {
        Elimina elimina = new Elimina();
        if (elimina.Delete(Nombre)) {
            return "Exito";
        } else {
            Mensaje = "Usuario no existe";
            return "Fallo";
        }

    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    
}
