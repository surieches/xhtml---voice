/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import ProfesorBeans.Contenido;
import ProfesorBeans.Group;
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

    public String InsertContenido(String Nombre, String XMLContenido, String Matricula, String PageContent, String ID_Grupo) {
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
            st.executeUpdate("INSERT INTO contenido(Nombre,XMLContenido,ProfesorUsuarioMatricula,PageContent,GrupoID) VALUES('" + Nombre + "','" + XMLContenido + "','" + Matricula + "','" + PageContent + "', '" + ID_Grupo + "')");
            ResultSet rs = st.executeQuery("SELECT contenido.ID FROM contenido WHERE contenido.Nombre='" + Nombre + "' AND contenido.XMLContenido='" + XMLContenido + "' AND contenido.GrupoID='" + ID_Grupo + "'");
            if (rs.next()) {
                return rs.getString("ID");
            } else {
                return null;
            }
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
     * Se inserta un nuevo grupo
     *
     * @param Nombre del grupo
     * @param Nivel del grupo
     * @param Matricula del profesor
     * @return true si se hizo correctamente
     */
    public boolean InsertGrupo(String Nombre, String Nivel, String Matricula) {
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
            int rs = st.executeUpdate("INSERT INTO grupo(ProfesorUsuarioMatricula,Nombre,Nivel) VALUES('" + Matricula + "','" + Nombre + "','" + Nivel + "')");
            boolean respuesta = false;
            if (rs > 0) {
                respuesta = true;
            }
            return respuesta;
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

    public List<List<String>> Grupos(String ID) {
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
            ResultSet rs = st.executeQuery("SELECT grupo.ID,grupo.Nombre FROM profesor INNER JOIN grupo ON grupo.ProfesorUsuarioMatricula=profesor.UsuarioMatricula WHERE profesor.UsuarioMatricula='" + ID + "'");
            List<String> list1 = new ArrayList<String>();
            List<String> list2 = new ArrayList<String>();
            list1.add("");
            list2.add("Selecciona Grupo");
            while (rs.next()) {
                list1.add(rs.getString("ID"));
                list2.add(rs.getString("Nombre"));
            }
            List<List<String>> list3 = new ArrayList<List<String>>();
            list3.add(list1);
            list3.add(list2);
            return list3;
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
     * Inserta la pregunta en la bd
     *
     * @param ContenidoID
     * @param Tipo
     * @param XML
     * @param Matricula
     */
    public void InsertPregunta(String ContenidoID, String Tipo, String XML, String Matricula) {
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
            int rs = st.executeUpdate("INSERT INTO preguntas(ContenidoID,Tipo,XMLPregunta,ProfesorUsuarioMatricula) VALUES('" + ContenidoID + "','" + Tipo + "','" + XML + "','" + Matricula + "')");
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

    /**
     * La informacion de los grupos
     *
     * @param ID del profesor
     * @return la lista con ID,Nombre,Nivel
     */
    public List<Group> GruposComplete(String ID) {
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
            ResultSet rs = st.executeQuery("SELECT grupo.ID,grupo.Nombre,grupo.Nivel FROM profesor INNER JOIN grupo ON grupo.ProfesorUsuarioMatricula=profesor.UsuarioMatricula WHERE profesor.UsuarioMatricula='" + ID + "'");
            List<Group> lg = new ArrayList<Group>();
            
            while (rs.next()) {
                Group g = new Group();
                g.setID(rs.getString("ID"));
                g.setNombre(rs.getString("Nombre"));
                int i =Integer.parseInt(rs.getString("Nivel"));
                g.setNivel(Tipos.get(i-1));
                lg.add(g);
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
     * Borra el grupo
     * @param g el grupo
     * @param ID del profe
     * @return si se llevo a cabo bien
     */
    public boolean DeleteGroup(Group g,String ID) {
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
            int rs = st.executeUpdate("DELETE FROM grupo WHERE grupo.ProfesorUsuarioMatricula='"+ID+"' AND grupo.ID='"+g.getID()+"'");
            boolean respuesta = false;
            if (rs > 0) {
                respuesta = true;
            }
            return respuesta;
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
     * Regresa el contenido de los grupos
     * @param ID la id del profesor
     * @return lista de contenidos
     */
    public List<Contenido> ContenidosComplete(String ID) {
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
            ResultSet rs = st.executeQuery("SELECT contenido.ID,contenido.Nombre,contenido.PageContent,grupo.Nombre AS NombreGrupo,grupo.Nivel FROM contenido INNER JOIN grupo ON grupo.ID = contenido.GrupoID WHERE grupo.ProfesorUsuarioMatricula='"+ID+"'");
            List<Contenido> lg = new ArrayList<Contenido>();
            while (rs.next()) {
                Contenido g = new Contenido();
                g.setID(rs.getString("ID"));
                g.setNombre(rs.getString("Nombre"));
                int i =Integer.parseInt(rs.getString("Nivel"));
                g.setNivel(Tipos.get(i-1));
                g.setPageContent(rs.getString("PageContent"));
                g.setGrupoNombre(rs.getString("NombreGrupo"));
                lg.add(g);
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
     * elimina un contenido
     * @param g el contenido
     * @param ID el id del profesor
     * @return true si se llevo bien a cabo
     */
    public boolean DeleteContent(Contenido g,String ID) {
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
            int rs = st.executeUpdate("DELETE FROM contenido WHERE contenido.ProfesorUsuarioMatricula='"+ID+"' AND contenido.ID='"+g.getID()+"'");
            boolean respuesta = false;
            if (rs > 0) {
                respuesta = true;
            }
            return respuesta;
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
    
}
