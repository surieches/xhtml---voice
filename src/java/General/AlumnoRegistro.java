
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import Beans.AlumnoComplete;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *
 * @author Maximus
 */
public class AlumnoRegistro extends ActionSupport implements ModelDriven<AlumnoComplete>{
    private AlumnoComplete alumno = new AlumnoComplete();
    
    @Override
    public String execute() throws Exception{
        System.out.println(alumno.getApmat());
        System.out.println(alumno.getAppat());
        System.out.println(alumno.getNombre());
        System.out.println(alumno.getCalle());
        System.out.println(alumno.getColonia());
        System.out.println(alumno.getCurp());
        System.out.println(alumno.getDelegacion());
        System.out.println(alumno.getEmail());
        System.out.println(alumno.getFenac());
        System.out.println(alumno.getFenac());
        System.out.println(alumno.getNumero());
        System.out.println(alumno.getPais());
        System.out.println(alumno.getPassword());
        
        return "SUCCESS";
    
    }
    
    @Override
    public AlumnoComplete getModel() {
        return alumno;
    }
    
}
