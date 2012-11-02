/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import AdministradorControl.DatosCon;
import java.util.ArrayList;
import General.*;
import Beans.BinUsuarioEs;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author IPNWIN
 */
public class ControlUsuarios {

    DatosCon dc;

    public ControlUsuarios() {
        dc = new DatosCon();
    }
    //obtiene todas las llamadas asociadas a
    //un determinado tel�fono

    public ArrayList<BinUsuarioEs> getTodos() {
        String query = "select u.Matricula as Matricula,ue.CURP as CURP"
                + "from Usuario u,usuario_especificacion ue "
                + "where u.Matricula=ue.Matricula";
        return getUsuario(query);
    }

    //metodo de apoyo al anterior
    private ArrayList<BinUsuarioEs> getUsuario(String sql) {
        ArrayList<BinUsuarioEs> usuarios = new ArrayList<BinUsuarioEs>();
        try {
            Connection cn = dc.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
                BinUsuarioEs us = new BinUsuarioEs();
                us.setMatricula(rs.getInt("Matricula"));
                us.setCURP(rs.getString("CURP"));
                
            }
            dc.cierraConexion(cn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return usuarios;
        }
    }
}
