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
import java.sql.*;

public class Insert extends ActionSupport {

    DatosCon dc;

    public Insert() {
        dc = new DatosCon();
    }

    public String execute() throws Exception {
        try {
            Connection con = dc.getConnection();

            Statement stmt = null;
            int matr = getMatricula();
            int tipo = getTipo();
            String pws = getPassword();
            String nom = getNombre();
            String pat = getApPat();
            String mate = getApMat();
            stmt = con.createStatement();
            int val = stmt.executeUpdate("INSERT into usuario(Matricula,Tipo,Password,Nombre,ApPat,ApMat) "
                    + "VALUES('" + matr + "' ,'" + tipo + "','" + pws + "','" + nom + "'"
                    + ",'" + pat + "','" + mate + "' )");
            if (val == 0) {
                return ERROR;
            } else {
                return SUCCESS;
            }
        } catch (Exception e) {
        }
        return null;
    }
    private int Matricula;
    private int Tipo;
    private String Password;
    private String Nombre;
    private String ApPat;
    private String ApMat;
    private Date fecha;

    public int getMatricula() {
        return Matricula;
    }

    public void setMatricula(int Matricula) {
        this.Matricula = Matricula;
    }

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApPat() {
        return ApPat;
    }

    public void setApPat(String ApPat) {
        this.ApPat = ApPat;
    }

    public String getApMat() {
        return ApMat;
    }

    public void setApMat(String ApMat) {
        this.ApMat = ApMat;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
