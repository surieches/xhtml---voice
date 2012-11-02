/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProfesorBeans;

import Beans.PreguntaProfesor;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maximus
 */
public class xhtmlEjercicios {

    FileWriter fstream;
    BufferedWriter out;
    String XML;
    List<PreguntaProfesor> Preguntas;
    private final String flash = "grammar.swf";

    public xhtmlEjercicios(List<PreguntaProfesor> Preguntas, String XML, String Path, String Name) {
        this.XML = XML;
        this.Preguntas = Preguntas;
        try {
            fstream = new FileWriter(Path + Name);
            out = new BufferedWriter(fstream);
            escribirEncabezado();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void escribirEncabezado() {
        try {
            out.write("<!DOCTYPE html PUBLIC \"-//W3C/DTD XHTML+Voice 1.0/EN\" \"xhtml+voice.dtd\">"
                    + "<html xmlns=\"http://www.w3.org/1999/xhtml\""
                    + " xmlns:ev=\"http://www.w3.org/2001/xml-events\">" + "\n");
            out.write("<head><title> EXERCISE </title>");
            escribirFormVoice();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void escribirFormVoice() {
        int i = 0;
        String aux;
        for (PreguntaProfesor p : Preguntas) {
            switch (p.getTipo()) {
                case 1:
                    aux = formMultipleChoice(p, i);
                    break;
                case 2:
                    aux = formFalseTrue(p, i);
                    break;
                case 3:
                    aux = formColumns(p, i);
                    break;
                case 4:
                    aux = formAutocomplete(p, i);
                    break;
                default:
                    aux = "";
                    break;
            }

            try {
                out.write(aux);
            } catch (IOException ex) {
                System.out.println(ex);
            }
            i++;
        }
        escribirScript();
    }

    /**
     * escribe el form de voice con la pregunta de opcion multiple
     *
     * @param p recibe la pregunta
     * @param i el numero de pregunta
     * @return regresa el form
     */
    private String formMultipleChoice(PreguntaProfesor p, int i) {
        String form = "<form xmlns=\"http://www.w3.org/2001/vxml\" id=\"question" + i + "\">"
                + "<field name=\"Option\">"
                + "<grammar><![CDATA[#JSGF V1.0;"
                + "grammar color;"
                + "public <color> = ";

        for (String s : p.getRespuesta()) {
            form += s + " | ";
        }

        form += "Next | Before | Start | Final | Qualify; ]]>"
                + "</grammar>"
                + "<prompt>" + p.getTitulo() + "</prompt>"
                + "<nomatch>I don't understand.</nomatch>"
                + "</field>"
                + "<filled><assign name=\"callToActionscript(Option)\" expr=\"Option\"/>"
                + "</filled>"
                + "</form>";
        return form;
    }
    
    /**
     * crea el form del autocomplete
     * @param p la pregunta
     * @param i el numero de la pregunta
     * @return 
     */
    private String formAutocomplete(PreguntaProfesor p, int i) {
        String form = "<form xmlns=\"http://www.w3.org/2001/vxml\" id=\"question" + i + "\">"
                + "<field name=\"Option\">"
                + "<grammar><![CDATA[#JSGF V1.0;"
                + "grammar color;"
                + "public <color> = ";

        for (String s : p.getRespuesta()) {
            form += s + " | ";
        }

        form += "Next | Before | Start | Final | Qualify; ]]>"
                + "</grammar>"
                + "<prompt>" + p.getPregunta().get(0) + p.getPregunta().get(1) + "</prompt>"
                + "<nomatch>I don't understand.</nomatch>"
                + "</field>"
                + "<filled><assign name=\"callToActionscript(Option)\" expr=\"Option\"/>"
                + "</filled>"
                + "</form>";
        return form;
    }

    /**
     * crea el form de una pregunta con falso y verdadero
     * @param p la pregunta
     * @param i el numero de pregunta
     * @return el form formado
     */
    private String formFalseTrue(PreguntaProfesor p, int i) {
        String form = "<form xmlns=\"http://www.w3.org/2001/vxml\" id=\"question"+i+"\">"
                + "<field name=\"Option\">"
                + "<grammar><![CDATA[#JSGF V1.0;"
                + "grammar color;"
                + "public <color> = False | True | Next | Before | Start | Final | Qualify; ]]>"
                + "</grammar>"
                + "<prompt>"+p.getPregunta().get(0)+"</prompt>"
                + "<nomatch>I don't understand.</nomatch>"
                + "</field>"
                + "<filled>"
                + "<assign name=\"callToActionscript(Option)\" expr=\"Option\"/>"
                + "</filled>"
                + "</form>";
        return form;
    }

    /**
     * crea el form de una pregunta con Columnas
     * @param p la pregunta
     * @param i el numero de pregunta
     * @return el form formado
     */
    private String formColumns(PreguntaProfesor p, int i) {
        String form = "<form xmlns=\"http://www.w3.org/2001/vxml\" id=\"question" + i + "\">"
                + "<field name=\"Option\">"
                + "<grammar><![CDATA[#JSGF V1.0;"
                + "grammar color;"
                + "public <color> = ";
        for (String s : p.getPregunta()) {
            form += s + " | ";
        }for (String s : p.getRespuesta()) {
            form += s + " | ";
        }
        form += "Next | Before | Start | Final | Qualify; ]]>"
                + "</grammar>"
                + "<prompt>" + p.getTitulo() + "</prompt>"
                + "<nomatch>I don't understand.</nomatch>"
                + "</field>"
                + "<filled><assign name=\"callToActionscript(Option)\" expr=\"Option\"/>"
                + "</filled>"
                + "</form>";
        return form;
    }
    
    
    /**
     * Escribe el script del xhtml del ejercicio
     */
    private void escribirScript() {
        try {
            out.write("<script type=\"text/javascript\" ev:event=\"load\" ev:observer=\"bod_id\"></script>"
                    + "<script ev:event=\"DOMActivate\" type=\"text/javascript\" >"
                    + "var contador=0;"
                    + "function load(){");
            for(int i=0;i<Preguntas.size();i++){
                    out.write("document.getElementById('"+i+"').style.visibility='hidden'; ");
                }
            out.write("document.getElementById('0').click();"
                    + "}"
                    + "function getFlashMovie(movieName) {"
                    + "var isIE = navigator.appName.indexOf(\"Microsoft\") != -1;"
                    + "return (isIE) ? window[movieName] : document[movieName];"
                    + "}"
                    + "function sendToJavaScript(option){"
                    + "contador=option;"
                    + "switch(option)"
                    + "{");
            for(int i=0;i<Preguntas.size();i++){
                    out.write("case "+i+":");
                    out.write("document.getElementById(option).click();break;");
                }
            out.write("}"
                    + "}"
                    + "function callToActionscript(str){"
                    + "getFlashMovie('flash').sendToActionscript(str);"
                    + "}"
                    + "</script></head>");
            escribirBody();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    /**
     * Escribe el body del xhtml
     */
    private void escribirBody() {
        try {
            out.write("<body onload=\"load()\"  bgcolor=\"gray\" topmargin=\"0\" leftmargin=\"0\" rightmargin=\"0\" bottommargin=\"0\">");
            
            for(int i=0;i<Preguntas.size();i++){
            out.write("<button ev:event=\"click\" ev:handler=\"#question"+i+"\" name=\""+i+"\" id=\""+i+"\"></button>"); 
            }
            
            out.write("<table width=\"100%\" border=\"0\" height=\"100%\" cellspacing=\"0\">"
                    + "<td valign=\"middle\">"
                    + "<div align=\"center\">"
                    + "<OBJECT>"
                    + "<embed src=\"Prototipo_Examen_Prueba.swf?nombrexml="+XML+"\" width=\"750\" height=\"570\" name=\"flash\"></embed>"
                    + "</OBJECT></div></td>"
                    + "</table>"
                    + "</body>"
                    + "</html>");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    
    public void Guardar() {
        try {
            out.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    

    
}
