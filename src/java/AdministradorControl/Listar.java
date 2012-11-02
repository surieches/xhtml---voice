/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministradorControl;

/**
 *
 * @author IPNWIN
 */
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import Beans.BinUsuario;
import Beans.BinUsuarioEs;
import java.util.ArrayList;
import BaseDeDatos.Administrador;

public class Listar extends ActionSupport {

    BinUsuarioEs usuario = new BinUsuarioEs();
    ArrayList<BinUsuarioEs> listaUsuarios = new ArrayList();
    Administrador admin = new Administrador();

    public String execute() throws Exception {
        listaUsuarios = admin.list();
        return "exito";
    }

    public BinUsuarioEs getUsuario() {
        return usuario;
    }

    public void setUsuario(BinUsuarioEs usuario) {
        this.usuario = usuario;
    }

    public ArrayList<BinUsuarioEs> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<BinUsuarioEs> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }
    
}