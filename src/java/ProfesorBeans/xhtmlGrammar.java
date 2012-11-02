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
public class xhtmlGrammar {

    String[] grammar;
    String NextPage;
    FileWriter fstream;
    BufferedWriter out;
    String XML;
    private final String flash = "grammar.swf";

    public xhtmlGrammar(String[] grammar, String NextPage, String XML, String Path, String Name) {
        this.grammar = grammar;
        this.NextPage = NextPage;
        this.XML = XML;
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
            out.write("<form xmlns=\"http://www.w3.org/2001/vxml\" id=\"grammar\">"
                    + "<field name=\"Option\">"
                    + "<grammar><![CDATA[#JSGF V1.0;"
                    + "grammar color;"
                    + "public <color> = ");
            for (String g : grammar) {
                out.write(g + " | ");
            }
            out.write("Next;]]></grammar><prompt>"
                    + "Say<value expr = \"voice_ptitle()\" /> </prompt> <nomatch>"
                    + "I don't understand.</nomatch></field> <filled>"
                    + "<assign name = \"callToActionscript(Option)\" expr = \"Option\" /></filled>"
                    + "</form>");
            escribirScript();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void escribirScript() {
        try {
            out.write("<script type=\"text/javascript\" ev:event=\"load\" ev:observer=\"bod_id\"></script>"
                    + "<script ev:event=\"DOMActivate\" type=\"text/javascript\" >"
                    + "var gramatica=new Array(");
            String aux = "";
            for (String g : grammar) {
                aux += "\"" + g + "\",";
            }
            aux = aux.substring(0, aux.length() - 1);
            out.write(aux);
            out.write(");");
            out.write("var contador=0;"
                    + "function load(){"
                    + "document.getElementById('1').style.visibility='hidden';"
                    + "document.getElementById('1').click();"
                    + "}"
                    + "function voice_ptitle(){"
                    + "return gramatica[contador];"
                    + "}"
                    + "function getFlashMovie(movieName) {"
                    + "var isIE = navigator.appName.indexOf(\"Microsoft\") != -1;"
                    + "return (isIE) ? window[movieName] : document[movieName];"
                    + "}"
                    + "function sendToJavaScript(option){"
                    + "if(option==1){"
                    + "contador++;"
                    + "}if(contador==gramatica.length){location.href='"+NextPage+"'}"
                    + "document.getElementById('1').click();"
                    + "}"
                    + "function callToActionscript(str) {"
                    + "getFlashMovie('flash').sendToActionscript(str)"
                    + "}"
                    + "</script>"
                    + "</head>");
            escribirBody();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void escribirBody() {
        try {
            out.write("<body onload=\"load()\"  bgcolor=\"gray\" topmargin=\"0\" leftmargin=\"0\" rightmargin=\"0\" bottommargin=\"0\" >"
                    + ""
                    + "<button ev:event=\"click\" ev:handler=\"#grammar\" name=\"1\" id=\"1\"></button>");

            out.write("<table width=\"100%\" border=\"0\" height=\"100%\" cellspacing=\"0\">"
                    + "<td valign=\"middle\">"
                    + "<div align=\"center\">"
                    + "<OBJECT>"
                    + "<embed src=\"grammar.swf?nombrexml=" + XML + "\" width=\"550\" height=\"400\" name=\"flash\"></embed>"
                    + "</OBJECT></div></td></table>"
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
