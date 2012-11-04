/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Profesor;

import Beans.PreguntaProfesor;
import ProfesorBeans.CrearPreguntas;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Maximus
 */
public class CrearContenidoControlador extends ActionSupport implements SessionAware,ServletRequestAware {

    private Map session;//la session
    private String Intro;//la lectura
    private String grammar[];//la gramatica
    private int NumPregunta;//el numero de la pregunta
    private int TipoPregunta;//el tipo de la pregunta
    private List<PreguntaProfesor> Preguntas;//las preguntas
    private String TextoPregunta;//el texto de la pregunta
    private String Respuesta;//la respuesta
    private String NombreContenido;//el nombre como se llamara el contenido
    private HttpServletRequest servletRequest;//para obtener el path
    
    private String[] preguntas_M;//las preguntas (la ocupo para Multiple Choice y Relacion de columnas)
    private String[] respuestas_M;//las respuestas de las columnas
    
    @Override
    public String execute() {
        session = ActionContext.getContext().getSession();
        System.out.println(Intro);
        session.put("Intro", Intro);
        return "SUCCESS";
    }

    public String Grammar() {
        session = ActionContext.getContext().getSession();
        session.put("grammar", grammar);
        return "SUCCESS";
    }

    public String Dialogo(){
        session = ActionContext.getContext().getSession();
        NumPregunta = 1;
        Preguntas = new ArrayList<PreguntaProfesor>();
        session.put("Preguntas", Preguntas);
        session.put("Conversacion", grammar);
        session.put("NumPregunta", NumPregunta);
        return "SUCCESS";
    }
    
    public String AgregarPregunta() {
        session = ActionContext.getContext().getSession();
        switch (TipoPregunta) {
            case 1:
                session.put("TipoPregunta", TipoPregunta);
                return "MULTIPLECHOICE";
            case 2:
                session.put("TipoPregunta", TipoPregunta);
                return "FALSETRUE";
            case 3:
                session.put("TipoPregunta", TipoPregunta);
                return "COLUMNS";
            case 4:
                session.put("TipoPregunta", TipoPregunta);
                return "AUTOCOMPLETE";
            default:
                return "FAILURE";
        }

    }

    public String GuardarPregunta() {
        session = ActionContext.getContext().getSession();
        TipoPregunta = (Integer) session.get("TipoPregunta");
        Preguntas = (List<PreguntaProfesor>) session.get("Preguntas");
        PreguntaProfesor pregunta = new PreguntaProfesor();
        CrearPreguntas crear = new CrearPreguntas();
        switch (TipoPregunta) {
            case 1:
                System.out.println("<<<Guardar Respuesta Multiple>>>");
                System.out.println("El texto de la pregunta es "+TextoPregunta);
                for(String s:preguntas_M){
                System.out.println("Las respuestas son "+s);}
                System.out.println("La respuestas es "+ Respuesta);
                pregunta =  crear.CrearMultipleChoice(pregunta,TextoPregunta,preguntas_M,Respuesta);
                Preguntas.add(pregunta);
                session.put("Preguntas", Preguntas);
                NumPregunta = (Integer) session.get("NumPregunta");
                NumPregunta++;
                session.put("NumPregunta", NumPregunta);
                return "SUCCESS";
            case 2:
                System.out.println("<<<Guardar Pregunta False True>>>");
                pregunta = crear.CrearFalseTrue(pregunta, TextoPregunta,Integer.parseInt(Respuesta));
                Preguntas.add(pregunta);
                session.put("Preguntas", Preguntas);
                NumPregunta = (Integer) session.get("NumPregunta");
                NumPregunta++;
                session.put("NumPregunta", NumPregunta);
                System.out.println("Pregunta False True");
                System.out.println("Texto "+Preguntas.get(NumPregunta-2).getPregunta().get(0));
                System.out.println("El tipo de pregunta es "+Preguntas.get(NumPregunta-2).getTipo());
                System.out.println("La respuesta es "+Preguntas.get(NumPregunta-2).getRespuestaCorrecta());
                return "SUCCESS";
            case 3:
                System.out.println("<<<Guardar Pregunta Columns>>>");
                pregunta = crear.CrearColumns(pregunta,TextoPregunta,preguntas_M,respuestas_M);
                Preguntas.add(pregunta);
                session.put("Preguntas", Preguntas);
                NumPregunta = (Integer) session.get("NumPregunta");
                NumPregunta++;
                session.put("NumPregunta", NumPregunta);
                return "SUCCESS";
            case 4:
                System.out.println("<<<Guardar Pregunta AUTOCOMPLETE>>>");
                pregunta = crear.Crearautocomplete(pregunta,respuestas_M);
                Preguntas.add(pregunta);
                session.put("Preguntas", Preguntas);
                NumPregunta = (Integer) session.get("NumPregunta");
                NumPregunta++;
                session.put("NumPregunta", NumPregunta);
                return "SUCCESS";
            default:
                return "FAILURE";
        }

    }

    public String GuardarContenido(){
        System.out.println(servletRequest.getSession().getServletContext().getRealPath("/"));
        String Path = servletRequest.getSession().getServletContext().getRealPath("/");
        CrearPreguntas crear = new CrearPreguntas();
        Preguntas = (List<PreguntaProfesor>) session.get("Preguntas");
        Intro = session.get("Intro").toString();
        grammar = (String[])session.get("grammar");
        String[] conver = (String[])session.get("Conversacion");
        String ID = session.get("ID").toString();
        System.out.println("Guardar las preguntas");
        crear.GuardarPreguntas(Preguntas,Path,ID,NombreContenido,Intro,grammar,conver);
        return "SUCCESS";
    }
    
    @Override
    public void setSession(Map map) {
        session = map;
    }

    public void setIntro(String Intro) {
        this.Intro = Intro;
    }

    public void setGrammar(String[] grammar) {
        this.grammar = grammar;
    }

    public int getNumPregunta() {
        return NumPregunta;
    }

    public void setTipoPregunta(int TipoPregunta) {
        this.TipoPregunta = TipoPregunta;
    }

    public void setTextoPregunta(String TextoPregunta) {
        this.TextoPregunta = TextoPregunta;
    }

    public void setRespuesta(String Respuesta) {
        this.Respuesta = Respuesta;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        servletRequest = hsr;
    }

    public void setNombreContenido(String NombreContenido) {
        this.NombreContenido = NombreContenido;
    }

    public void setPreguntas_M(String[] preguntas_M) {
        this.preguntas_M = preguntas_M;
    }

    public void setRespuestas_M(String[] respuestas_M) {
        this.respuestas_M = respuestas_M;
    }


    
}
