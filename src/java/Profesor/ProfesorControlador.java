/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Profesor;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Maximus
 */
public class ProfesorControlador extends ActionSupport implements SessionAware{
    
    
    
    
    @Override
    public void setSession(Map<String, Object> map) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
