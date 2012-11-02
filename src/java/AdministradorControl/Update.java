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

public class Update extends ActionSupport {

    DatosCon dc;

    public Update() {
        dc = new DatosCon();
    }

    public String execute() throws Exception {
        try {
            Connection con = dc.getConnection();

            Statement stmt = null;
            int matr = getMatricula();
            int matrN = getMatriculaNueva();
            int tipo = getTipo();
            String pws = getPassword();
            String nom = getNombre();
            String pat = getApPat();
            String mate = getApMat();
            stmt = con.createStatement();
            String sql="UPDATE usuario SET Matricula='" + matrN + "',Tipo='" + tipo + "',Password='" + pws + "',Nombre='" + nom + "',ApPat='" + pat + "',ApMat='" + mate + "' WHERE Matricula='" + matr + "'";
            System.out.println(sql);
            int val = stmt.executeUpdate(sql);
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
    private int MatriculaNueva;
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

    public int getMatriculaNueva() {
        return MatriculaNueva;
    }

    public void setMatriculaNueva(int MatriculaNueva) {
        this.MatriculaNueva = MatriculaNueva;
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
