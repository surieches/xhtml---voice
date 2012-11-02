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
public class xhtmlConversacion {
    String[] conver;
    String NextPage;
    FileWriter fstream;
    BufferedWriter out;

    public xhtmlConversacion(String[] conver, String NextPage, String Path, String Name) {
        this.conver = conver;
        this.NextPage = NextPage;
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
            out.write("<head><title> GRAMMAR </title>");
            escribirFormVoice();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void escribirFormVoice() {
        try {
            for(int i=0;i<conver.length;i++){
            out.write("<form xmlns=\"http://www.w3.org/2001/vxml\" id=\"f"+i+"\">"
                    + "<field name=\"Lectura\">"
                    + "<grammar><![CDATA[#JSGF V1.0;"
                    + "grammar Lectura;"
                    + "public <Lectura> = ");
            if((conver.length-1)==i){
                out.write("");
            }else{
                out.write(conver[i+1] + " | ");
            }
            out.write("Next;]]></grammar><prompt>"
                    + conver[i] +" </prompt> <nomatch>"
                    + "I don't understand.</nomatch></field> <filled>"
                    + "<assign name = \"voice_ptitle(Lectura)\" expr = \"Lectura\" /></filled>"
                    + "</form>");
            }
            escribirScript();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void escribirScript() {
        try {
            out.write("<script type=\"text/javascript\" >"
                    + "var contador=0;"
                    + "function load(){");
            for(int i=0;i<conver.length;i++){
                out.write("document.getElementById('"+i+"').style.visibility='hidden';");
            }
		out.write("document.getElementById('p'+(contador+1)).style.color=\"#ff0000\";"
                        + "document.getElementById(contador++).click();"
                        + "}"
                        + "function getFlashMovie(movieName) {"
                        + "var isIE = navigator.appName.indexOf(\"Microsoft\") != -1;"
                        + "return (isIE) ? window[movieName] : document[movieName];"
                        + "}"
                        + "function voice_ptitle(str){"
                        + "if(str == 'Next'){"
                        + "location.href='"+NextPage+"';"
                        + "}"
                        + "document.getElementById('p'+contador).style.color=\"#000000\";"
                        + "contador+=2;"
                        + "document.getElementById(contador-1).click();"
                        + "document.getElementById('p'+contador).style.color=\"#ff0000\";"
                        + "}"
                        + "function callToActionscript(str) {"
                        + "}</script></head>");
            escribirBody();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void escribirBody() {
        try {
            out.write("<body onload=\"load()\">"
                    + "<h1>Conversation</h1>");
            
            for(int i = 0;i<conver.length;i++){
                out.write("<button ev:event=\"click\" ev:handler=\"#f"+i+"\" name=\""+i+"\" id=\""+i+"\"></button>");
            }
  
            for(int i = 0;i<conver.length;i++){
                out.write("<p id=\"p"+i+"\">"+conver[i]+"</p>");
            }
            
            out.write("</body></html>");
  

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
