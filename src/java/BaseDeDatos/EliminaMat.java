/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

/**
 *
 * @author IPNWIN
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import AdministradorControl.*;

/**
 *
 * @author IPNWIN
 */
public class EliminaMat {

    private int Matricula;
    DatosCon dc = new DatosCon();

    public boolean Delete(int Matricula) {
        Connection con = null;

        try {
            con = dc.getConnection();
            Statement st = con.createStatement();

            int eliminado = st.executeUpdate("delete from usuario where Matricula='" + Matricula + "'");

            if (eliminado == 1) {
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

    public int getMatricula() {
        return Matricula;
    }
}
