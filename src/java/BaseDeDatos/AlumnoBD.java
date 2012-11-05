/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import AlumnoBeans.ContenidosVer;
import AlumnoBeans.GruposR;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author Maximus
 */
public class AlumnoBD {
    
    /**
     * Lista los grupos disponibles
     * @return regresa la lista con los grupos
     */
    public List<GruposR> CalificacionesComplete() {
        Connection con = null;
        List<String> Tipos = new ArrayList<String>();
        Tipos.add("Nivel Principiante");
        Tipos.add("Nivel Básico");
        Tipos.add("Nivel Intermedio");
        Tipos.add("Nivel Avanzado");
        Tipos.add("Conversacional");
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
            ResultSet rs = st.executeQuery("SELECT grupo.ID,grupo.Nombre AS NombreGrupo,grupo.Nivel,usuario.APPat,usuario.APMat,usuario.Nombre AS NombreProfesor FROM grupo INNER JOIN profesor ON profesor.UsuarioMatricula=grupo.ProfesorUsuarioMatricula INNER JOIN usuario ON usuario.Matricula=profesor.UsuarioMatricula");
            List<GruposR> lg = new ArrayList<GruposR>();
            while (rs.next()) {
                GruposR cal = new GruposR();
                cal.setID(rs.getString("ID"));
                cal.setNombreGrupo(rs.getString("NombreGrupo"));
                int i =Integer.parseInt(rs.getString("Nivel"));
                cal.setNivel(Tipos.get(i-1));
                cal.setAppat(rs.getString("APPat"));
                cal.setApmat(rs.getString("APMat"));
                cal.setNombreProfesor(rs.getString("NombreProfesor"));
                lg.add(cal);
            }
            return lg;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
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
    
    /**
     * inscribe un alumno al grupo
     * @param Matricula del alumno
     * @param ID_Grupo delgrupo
     * @return true si se hizo correctamente
     */
    public boolean InsertGroupAlumno(String Matricula, String ID_Grupo) {
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
            int r = st.executeUpdate("INSERT INTO alumno_grupo(Alumno_ID,GupoID) VALUES('"+Matricula+"','"+ID_Grupo+"')");
            if (r>0) {
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
    
    
    /**
     * La lista de contenidos que puede hacer
     * @param ID del usuario
     * @return la lista con todos los contenidos
     */
    public List<ContenidosVer> ContenidosComplete(String ID) {
        Connection con = null;
        List<String> Tipos = new ArrayList<String>();
        Tipos.add("Nivel Principiante");
        Tipos.add("Nivel Básico");
        Tipos.add("Nivel Intermedio");
        Tipos.add("Nivel Avanzado");
        Tipos.add("Conversacional");
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
            ResultSet rs = st.executeQuery("SELECT grupo.Nombre AS NombreGrupo,grupo.Nivel as Nivel,contenido.Nombre AS ContenidoNombre,contenido.ID AS ContenidoID,contenido.PageContent AS Pagina FROM alumno_grupo INNER JOIN grupo ON grupo.ID=alumno_grupo.GupoID INNER JOIN contenido ON contenido.GrupoID=grupo.ID WHERE alumno_grupo.Alumno_ID='"+ID+"'");
            List<ContenidosVer> lg = new ArrayList<ContenidosVer>();
            while (rs.next()) {
                ContenidosVer cal = new ContenidosVer();
                cal.setNombreGrupo(rs.getString("NombreGrupo"));
                int i =Integer.parseInt(rs.getString("Nivel"));
                cal.setNivel(Tipos.get(i-1));
                cal.setContenidoNombre(rs.getString("ContenidoNombre"));
                cal.setContenidoID(rs.getString("ContenidoID"));
                cal.setPagina(rs.getString("Pagina"));
                lg.add(cal);
            }
            return lg;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
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
