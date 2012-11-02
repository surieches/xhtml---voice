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
public class ProfesorBD {

    public String NumPreguntas(String ID) {
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
            ResultSet rs = st.executeQuery("SELECT COUNT(preguntas.ID) AS Numero FROM preguntas ");
            String respuesta = "0";
            if (rs.next()) {
                respuesta = rs.getString("Numero");
            }
            return respuesta;
        } catch (Exception ex) {
            System.out.println(ex);
            return "0";
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
    
    public String NumContenido(String ID) {
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
            ResultSet rs = st.executeQuery("SELECT COUNT(contenido.ID) AS Numero FROM contenido");
            String respuesta = "0";
            if (rs.next()) {
                respuesta = rs.getString("Numero");
            }
            return respuesta;
        } catch (Exception ex) {
            System.out.println(ex);
            return "0";
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
    
    
    public void InsertContenido(String Nombre,String XMLContenido,String Matricula,String PageContent){
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
            int rs = st.executeUpdate("INSERT INTO contenido(Nombre,XMLContenido,ProfesorUsuarioMatricula,PageContent) VALUES('"+Nombre+"','"+XMLContenido+"','"+Matricula+"','"+PageContent+"')");
            boolean respuesta = false;
            if (rs>0) {
                respuesta = true;
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
    }
}
