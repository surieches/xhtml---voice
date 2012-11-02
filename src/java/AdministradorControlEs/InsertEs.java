/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministradorControlEs;

/**
 *
 * @author IPNWIN
 */
import AdministradorControl.*;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;

public class InsertEs extends ActionSupport {

    DatosCon dc;

    public InsertEs() {
        dc = new DatosCon();
    }

    public String execute() throws Exception {
        try {
            Connection con = dc.getConnection();

            Statement stmt = null;
            int matr = getMatricula();
            String curp = getCURP();
            Date fnac = getFecha_nac();
            String call = getCalle();
            int num = getNumero();
            String col = getColonia();
            String del = getDelegacion();
            String pai = getPais();
            String imeil = getEmail();
            stmt = con.createStatement();
            String sql = "insert into usuario_especificacion(Matricula,CURP,Fecha_Nacimiento,Calle,Numero,Colonia,Delegacion,Pais,`E-mail`) "
                    + "VALUES(" + matr + " ,'" + curp + "','" + fnac + "','" + call + "'"
                    + "," + num + ",'" + col + "','" + del + "','" + pai + "','" + imeil + "')";
            System.out.println(sql);
            int val = stmt.executeUpdate(sql);
            System.out.println(val);

            if (val == 0) {
                return ERROR;
            } else if (val == 1) {
                return SUCCESS;
            } else {
                return INPUT;
            }
        } catch (Exception e) {
        }
        return null;
    }
    private int Matricula;
    private String CURP;
    private Date Fecha_nac;
    private String Calle;
    private String Colonia;
    private int Numero;
    private String Delegacion;
    private String Pais;
    private String Email;

    public int getMatricula() {
        return Matricula;
    }

    public void setMatricula(int Matricula) {
        this.Matricula = Matricula;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public java.sql.Date getFecha_nac() {
        return Fecha_nac;
    }

    public void setFecha_nac(java.sql.Date Fecha_nac) {
        this.Fecha_nac = Fecha_nac;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public String getColonia() {
        return Colonia;
    }

    public void setColonia(String Colonia) {
        this.Colonia = Colonia;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public String getDelegacion() {
        return Delegacion;
    }

    public void setDelegacion(String Delegacion) {
        this.Delegacion = Delegacion;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
}
