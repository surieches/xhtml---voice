/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministradorControl;

/**
 *
 * @author IPNWIN
 */

/**
 *
 * @author IPNWIN
 */
import BaseDeDatos.Elimina;
import BaseDeDatos.EliminaMat;
import BaseDeDatos.Login;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Maximus
 */
public class EliminarMat extends ActionSupport {

    private String Mensaje = "";
    private int Matricula=0;

    @Override
    public String execute() {
        EliminaMat elimina = new EliminaMat();
        if (elimina.Delete(Matricula)) {
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

    public int getMatricula() {
        return Matricula;
    }

    public void setMatricula(int Matricula) {
        this.Matricula = Matricula;
    }

    

    
}
