/* * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import AdministradorControl.DatosCon;
import Beans.BinUsuarioEs;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import Beans.BinUsuarioEs;

/**
 *
 * @author IPNWIN
 */
public class Administrador {

    ArrayList<BinUsuarioEs> lista = new ArrayList<BinUsuarioEs>();
    BinUsuarioEs BinUs = null;
    DatosCon dc = new DatosCon();

    public ArrayList<BinUsuarioEs> list() {


        Connection con = null;
        try {
            con = dc.getConnection();
            Statement st = con.createStatement();
            String consulta = "select u.Matricula as Matricula,u.Tipo as Tipo,u.Nombre as Nombre,"
                    + "u.ApPat as ApPat,u.ApMat as ApMat,ue.CURP as CURP,"
                    + "ue.Fecha_Nacimiento as Fecha_Nac,ue.Calle as Calle,ue.Numero as Numero,"
                    + "ue.Colonia as Colonia,ue.Delegacion as Delegacion,ue.Pais as Pais,ue.`E-mail` as Imeil"
                    + " from usuario u left join usuario_especificacion ue on u.Matricula=ue.Matricula";
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                BinUs = new BinUsuarioEs();
                BinUs.setMatricula(rs.getInt("Matricula"));
                BinUs.setTipo(rs.getInt("Tipo"));
                BinUs.setNombre(rs.getString("Nombre"));
                BinUs.setApPat(rs.getString("ApPat"));
                BinUs.setApMat(rs.getString("ApMat"));
                BinUs.setCURP(rs.getString("CURP"));
                BinUs.setFecha_nac(rs.getDate("Fecha_Nac"));
                BinUs.setCalle(rs.getString("Calle"));
                BinUs.setNumero(rs.getInt("Numero"));
                BinUs.setColonia(rs.getString("Colonia"));
                BinUs.setDelegacion(rs.getString("Delegacion"));
                BinUs.setPais(rs.getString("Pais"));
                BinUs.setEmail(rs.getString("Imeil"));
                lista.add(BinUs);
            }

        } catch (Exception ex) {
            System.out.println(ex);

        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        return lista;
    }

    public ArrayList<BinUsuarioEs> getLista() {
        return lista;
    }

    public void setLista(ArrayList<BinUsuarioEs> lista) {
        this.lista = lista;
    }

    public BinUsuarioEs getBinUs() {
        return BinUs;
    }

    public void setBinUs(BinUsuarioEs BinUs) {
        this.BinUs = BinUs;
    }
}
