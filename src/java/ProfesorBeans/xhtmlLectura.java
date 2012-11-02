/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProfesorBeans;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Maximus
 */
public class xhtmlLectura {

    FileWriter fstream;
    BufferedWriter out;
    String Lectura;
    String NextPage;

    public xhtmlLectura(String Lectura, String contentName, String Path, String NextPage) {
        this.Lectura = Lectura;
        this.NextPage = NextPage;
        try {
            fstream = new FileWriter(Path + contentName);
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
            out.write("<head><title> Lecture </title>");
            escribirFormVoice();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void escribirFormVoice() {
        try {
            out.write("<form xmlns=\"http://www.w3.org/2001/vxml\" id=\"grammar\">"
                    + "<field name=\"Lectura\">   <grammar><![CDATA[#JSGF V1.0;"
                    + "grammar Lectura;"
                    + "public <Lectura> = Next; ]]>"
                    + "</grammar><prompt>");
            out.write(Lectura);
            out.write("</prompt></field><filled>"
                    + "<assign name=\"callToActionscript(Lectura)\" expr=\"Lectura\"/>"
                    + "</filled></form>");
            escribirScript();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void escribirScript() {
        try {
            out.write("<script type=\"text/javascript\" >"
                    + "function load(){"
                    + "document.getElementById('1').style.visibility='hidden';"
                    + "document.getElementById('1').click();"
                    + "}"
                    + "function getFlashMovie(movieName) {"
                    + "var isIE = navigator.appName.indexOf(\"Microsoft\") != -1;"
                    + "return (isIE) ? window[movieName] : document[movieName];"
                    + "}"
                    + "function sendToJavaScript(option){"
                    + "document.getElementById('1').click();"
                    + "}"
                    + "function callToActionscript(str) {"
                    + "location.href=\""+NextPage+"\""
                    + "}"
                    + "</script>");
            escribirBody();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void escribirBody() {
        try {
            out.write("</head>"
                    + "<body onload=\"load()\">"
                    + "<h1>Lecture</h1>"
                    + "<button ev:event=\"click\" ev:handler=\"#grammar\" name=\"1\" id=\"1\"></button>"
                    + "<p>"+Lectura+"</p>"
                    + "</body></html>");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public void Guardar(){
        try {
            out.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    
}
