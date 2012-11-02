/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministradorControl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author IPNWIN
 */
public class DatosCon {

    public Connection getConnection() {
        Connection con = null;
        Statement stmt = null;
        try {
            // Obtiene el contexto JNDI
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            // Obtiene el DataSource del contexto
            DataSource ds = (DataSource) envCtx.lookup("jdbc/englishvoice");
            // Se obtiene una conexion al DataSource
            con = ds.getConnection();
           // stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }


    public void cierraConexion(Connection cn) {
        try {
            if (cn != null && !cn.isClosed()) {
                cn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String regresar() {
        return "exito";
    }
    public String porNombre() {
        return "exito";
    }
    public String porMat() {
        return "exito";
    }
}
