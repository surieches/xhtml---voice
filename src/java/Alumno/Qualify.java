/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Alumno;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Maximus
 */
public class Qualify extends ActionSupport implements SessionAware {

    private Map session;//la session
    private String Cal;
    private String ID;

    @Override
    public String execute() {
        session = ActionContext.getContext().getSession();
        return "SUCCESS";
    }

    @Override
    public void setSession(Map map) {
        this.session = map;
    }

    public void setCal(String Cal) {
        this.Cal = Cal;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    
}
