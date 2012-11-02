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
import AdministradorControl.DatosCon;
/**
 *
 * @author IPNWIN
 */
public class Elimina {
    private String Nombre;
   
DatosCon dc = new DatosCon();
    public boolean Delete(String Nombre) {
        Connection con = null;
        
        try {
            con = dc.getConnection();
            Statement st = con.createStatement();
            
            int eliminado = st.executeUpdate("delete from usuario where Nombre='"+Nombre+"'");

            if (eliminado==1) {
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

}
