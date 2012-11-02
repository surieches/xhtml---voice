/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author Maximus
 */
public class Login {

    private String Nombre;
    private int Tipo;
    private String ID;

    public boolean Validar(String User, String Pass) {
        Connection con = null;
        try {
            // Obtiene el contexto JNDI
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            // Obtiene el DataSource del contexto
            DataSource ds = (DataSource) envCtx.lookup("jdbc/englishvoice");
            // Se obtiene una conexion al DataSource
            con = ds.getConnection();
            // A partir de aquí utilice la conexión como lo hace habitualmente
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT usuario.Nombre,usuario.Tipo,usuario.Matricula FROM usuario WHERE usuario.Password='" + Pass + "' AND usuario.Matricula='" + User + "'");

            if (rs.next()) {
                Nombre = rs.getString("Nombre");
                Tipo = Integer.parseInt(rs.getString("Tipo"));
                ID = rs.getString("Matricula");
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex);
            return false;

        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }

    public String getNombre() {
        return Nombre;
    }

    public int getTipo() {
        return Tipo;
    }

    public String getID() {
        return ID;
    }
    
    
}
