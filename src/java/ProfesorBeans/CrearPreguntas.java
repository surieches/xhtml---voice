package ProfesorBeans;

import BaseDeDatos.ProfesorBD;
import Beans.PreguntaProfesor;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maximus
 */
public class CrearPreguntas {

    ProfesorBD bd;

    /**
     * Crea el objeto de opcion multiple
     *
     * @param pregunta el tipo de pregunta
     * @param TextoPregunta el titulo de la pregunta
     * @param preguntas las posibles respuestas
     * @param Respuesta el numero de respuesta adecuado
     * @return el objeto de la pregunta correcto
     */
    public PreguntaProfesor CrearMultipleChoice(PreguntaProfesor pregunta, String TextoPregunta, String[] preguntas, String Respuesta) {
        pregunta.setTipo(1);
        pregunta.setTitulo(TextoPregunta);
        List<String> answer = new ArrayList<String>();
        for (String s : preguntas) {
            if (s.equals("")) {
                break;
            } else {
                answer.add(s);
            }
        }
        pregunta.setRespuesta(answer);
        int resp = Integer.parseInt(Respuesta) - 1;
        pregunta.setRespuestaCorrecta(resp);
        return pregunta;
    }

    /**
     * Crea la pregunta de Falso Verdadero
     *
     * @param pregunta la pregunta
     * @return la pregunta realizada
     */
    public PreguntaProfesor CrearFalseTrue(PreguntaProfesor pregunta, String Texto, int Respuesta) {
        pregunta.setTipo(2);
        if (Respuesta == 1) {
            Respuesta = 1;
        } else {
            Respuesta = 0;
        }
        pregunta.setRespuestaCorrecta(Respuesta);
        List<String> text = new ArrayList<String>();
        text.add(Texto);
        pregunta.setPregunta(text);
        return pregunta;
    }

    /**
     * Crea la pregunta de columnas
     * @param pregunta la pregunta
     * @param Titulo el titulo
     * @param Pregunta las preguntas
     * @param Respuestas las respuestas
     * @return la pregunta ya lista
     */
    public PreguntaProfesor CrearColumns(PreguntaProfesor pregunta,String Titulo,String[] Pregunta,String[] Respuestas) {
        pregunta.setTipo(3);
        pregunta.setPregunta(Arrays.asList(Pregunta));//las preguntas
        // read in the data
        int[] a = {1, 2, 3, 4};
        int N = a.length;
        // shuffle
        for (int i = 0; i < N; i++) {
            // int from remainder of deck
            int r = i + (int) (Math.random() * (N - i));
            int swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
        // print permutation
        for (int i = 0; i < N; i++) {
            System.out.println(a[i]);
        }
        List<String> aux = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            int l = 0;
            for (int j : a) {
                if (j == i + 1) {
                    break;
                }
                l++;
            }
            aux.add(Respuestas[l]);
        }
        pregunta.setRespuesta(aux);//las respuestas ya ordenadas
        String jojo="";
        for(int i=0;i<4;i++){
            jojo+=(i+1)+"-"+a[i]+";";
        }
        jojo = jojo.substring(0, jojo.length()-1);
        pregunta.setRespcol(jojo);//la respuesta del ejercicio
        pregunta.setTitulo(Titulo);//el titulo de la pregunta
        return pregunta;
    }

    /**
     * Crea la pregunta de autocomplete
     *
     * @param pregunta la pregunta
     * @return la pregunta realizada
     */
    public PreguntaProfesor Crearautocomplete(PreguntaProfesor pregunta,String Textos[]) {
        pregunta.setTipo(4);
        if(Textos[0]==null){
            Textos[0]="";
        }
        if(Textos[1]==null){
            Textos[1]="";
        }
        List<String> list = new ArrayList<String>();
        list.add(Textos[0]);
        list.add(Textos[2]);
        pregunta.setPregunta(list);//las preguntas
        System.out.println("El texto 1 " + pregunta.getPregunta().get(0));
        System.out.println("El texto 2 " + pregunta.getPregunta().get(1));
        list = new ArrayList<String>();
        list.add(Textos[1]);
        pregunta.setRespuesta(list);
        System.out.println("la respuesta " + pregunta.getRespuesta().get(0));
        return pregunta;
    }

    /**
     * Guarda las preguntas
     *
     * @param Preguntas array de preguntas profesor
     * @param Path el path general del profesor
     * @param NombreContenido El nombre del contenido
     * @param ID el id del profesor
     */
    public void GuardarPreguntas(List<PreguntaProfesor> Preguntas, String Path, String ID, String NombreContenido, String Lectura, String[] grammar , String[] conver) {
        bd = new ProfesorBD();//se instancia la bd
        int Num = Integer.parseInt(bd.NumPreguntas(ID)) + 1;//el numero de peguntas que hay
        int NumContenido = Integer.parseInt(bd.NumContenido(ID)) + 1;//el numero del contenido
        String ContentName = "L" + ID + NumContenido + ".xhtml";//el path de la pagina principal del contenido
        bd.InsertContenido(NombreContenido, "C" + ID + NumContenido + ".xml", ID, ContentName);//insertamos el contenido
        System.out.println("El numero de preguntas anteriores es" + Num);
        System.out.println("El numero de preguntas es" + Preguntas.size());
        System.out.println("El nombre del contenido es " + NombreContenido);
        Path += "Contenidos\\";//la path de los contenidos
        System.out.println("El path donde se guardara es " + Path);
        CrearLectura(Path, Lectura, ContentName, "G" + ID + NumContenido + ".xhtml");//creamos el html de la lectura
        CrearGrammar(Path, grammar, "G" + ID + NumContenido +".xhtml", ID + Num + ".xml", "D" + ID + NumContenido + ".xhtml");
        CrearDialogos(Path, conver, "D" + ID + NumContenido +".xhtml",  "C" + ID + NumContenido + ".xhtml");
        Num++;

        List<String> xmls = new ArrayList<String>();
        String xml = "";
        for (PreguntaProfesor pregunta : Preguntas) {
            switch (pregunta.getTipo()) {
                case 1:
                    xml = GuardarPreguntaMultipleChoice(Path, pregunta, Num, ID);
                    break;
                case 2:
                    xml = GuardarPreguntaFalseTrue(Path, pregunta, Num, ID);
                    break;
                case 3:
                    xml = GuardarPreguntaColumns(Path, pregunta, Num, ID);
                    break;
               case 4:
                    xml = GuardarPreguntaAutocomplete(Path, pregunta, Num, ID);
                    break;
            }
            Num++;
            xmls.add(xml);
        }
        xml = CrearXMLPrincipal(Path,Preguntas,ID,NumContenido,xmls);
        
        new xhtmlEjercicios(Preguntas, xml, Path, "C" + ID + NumContenido + ".xhtml").Guardar();
        System.out.println(xmls.toString());
    }

    /**
     * Guarda el tipo de pregunta FalseTrue
     *
     * @param Path direccion donde se guardará
     * @param pregunta la pregunta que se guardar
     * @param Num el numero de la pregunta
     * @param ID la matricula del profesor
     */
    private String GuardarPreguntaFalseTrue(String Path, PreguntaProfesor pregunta, int Num, String ID) {
        try {
            Element FAT = new Element("FAT");
            FAT.setAttribute(new Attribute("PLANTILLA", "prototipo_FV.swf"));
            FAT.setAttribute(new Attribute("TEXTO", pregunta.getPregunta().get(0)));
            FAT.setAttribute(new Attribute("RESPUESTA", "" + pregunta.getRespuestaCorrecta()));
            Document doc = new Document(FAT);

            // new XMLOutputter().output(doc, System.out);
            XMLOutputter xmlOutput = new XMLOutputter();
            // display nice nice
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter(Path + ID + Num + ".xml"));
            System.out.println("FAT saved file:" + Path + ID + Num + ".xml");
            return ID + Num + ".xml";
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Crea el xhtml de la lectura
     *
     * @param Path el path donde se guardara
     * @param Lectura la lectura que se pondra
     * @param ContentName el nombre del contenido
     */
    private void CrearLectura(String Path, String Lectura, String ContentName, String PaginaSiguiente) {
        System.out.println("Se guardará lectura");
        new xhtmlLectura(Lectura, ContentName, Path, PaginaSiguiente).Guardar();
        System.out.println("Lectura Guardada");
    }

    /**
     * Crea la pagina del grammar
     *
     * @param Path el path donde se guardará
     * @param grammar el grammar
     * @param Pagina la pagina como se llamará
     * @param XML el xml del grammar como se llamará
     * @param PaginaSiguiente que se linkea con los ejercicios
     */
    private void CrearGrammar(String Path, String[] grammar, String Pagina, String XML, String PaginaSiguiente) {
        try {
            Element FAT = new Element("GRAMMAR");
            Document doc = new Document(FAT);

            for (String g : grammar) {
                Element option = new Element("OPTION");
                option.setText(g);
                doc.getRootElement().addContent(option);
            }

            // new XMLOutputter().output(doc, System.out);
            XMLOutputter xmlOutput = new XMLOutputter();
            // display nice nice
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter(Path + XML));
            System.out.println("GRAMMAR saved file:" + Path + XML);
        } catch (Exception e) {
            System.out.println(e);
        }
        new xhtmlGrammar(grammar, PaginaSiguiente, XML, Path, Pagina).Guardar();

    }

    private String GuardarPreguntaMultipleChoice(String Path, PreguntaProfesor pregunta, int Num, String ID) {
        try {
            Element OPCION_MULTIPLE = new Element("OPCION_MULTIPLE");
            OPCION_MULTIPLE.setAttribute(new Attribute("PLANTILLA", "prototipo_OM.swf"));
            OPCION_MULTIPLE.setAttribute(new Attribute("TEXTO", pregunta.getTitulo()));
            OPCION_MULTIPLE.setAttribute(new Attribute("RESPUESTA", "" + pregunta.getRespuestaCorrecta()));
            Document doc = new Document(OPCION_MULTIPLE);

            for (String g : pregunta.getRespuesta()) {
                Element option = new Element("OPCION");
                option.setText(g);
                doc.getRootElement().addContent(option);
            }

            // new XMLOutputter().output(doc, System.out);
            XMLOutputter xmlOutput = new XMLOutputter();
            // display nice nice
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter(Path + ID + Num + ".xml"));
            System.out.println("Multiple CHOICE saved file:" + Path + ID + Num + ".xml");
            return ID + Num + ".xml";
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    
    /**
     * crea el xml principal del examen
     * @param Path dirreccion donde lo guarda
     * @param Preguntas las preguntas que va a guardar
     * @param ID el id del usuario
     * @param NumContenido el numero del contenido
     * @param xmls los xmls generados de las preguntas
     * @return el nombre del xml que genero
     */
    private String CrearXMLPrincipal(String Path, List<PreguntaProfesor> Preguntas, String ID, int NumContenido,List<String> xmls) {
        try {
            List<String> plantillas = new ArrayList<String>();
            plantillas.add("Plantillas");
            plantillas.add("prototipo_OM_Prueba.swf");
            plantillas.add("prototipo_FV.swf");
            plantillas.add("RelCol.swf");
            plantillas.add("autocomplete.swf");
            
            Element EXAMEN = new Element("EXAMEN");
            EXAMEN.setAttribute(new Attribute("TITULO", "Examen"));
            EXAMEN.setAttribute(new Attribute("DESCRIPCION", "Examen"));
            EXAMEN.setAttribute(new Attribute("BARRA", "Barra_de_navegacion.swf"));
            EXAMEN.setAttribute(new Attribute("FINAL", "Final.swf"));
            Document doc = new Document(EXAMEN);
            
            System.out.println("xmls "+xmls.toString());
            System.out.println("El tamaño de prehintas es "+Preguntas.size());
            int i=0;
            for (PreguntaProfesor p : Preguntas) {
                Element PREGUNTA = new Element("PREGUNTA");
                PREGUNTA.setAttribute(new Attribute("PLANTILLA", plantillas.get(p.getTipo())));
                PREGUNTA.setText(xmls.get(i++));
                doc.getRootElement().addContent(PREGUNTA);
            }
            System.out.println("xmls "+xmls.toString());
            // new XMLOutputter().output(doc, System.out);
            XMLOutputter xmlOutput = new XMLOutputter();
            // display nice nice
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter(Path + "XP"+ID+NumContenido+".xml"));
            System.out.println("PRINCIPAL EXAMEN XML saved file:" + Path + "XP"+ID+NumContenido+".xml");
            return "XP"+ID+NumContenido+".xml";
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Crea el xml de la pregunta columnas
     * @param Path el path
     * @param pregunta la pregunta que se guardara
     * @param Num el numero de la pregunta
     * @param ID el id del profesor
     * @return el nombre del xml
     */
    private String GuardarPreguntaColumns(String Path, PreguntaProfesor pregunta, int Num, String ID) {
        try {
            Element RELACION_DE_COLUMNAS = new Element("RELACION_DE_COLUMNAS");
            RELACION_DE_COLUMNAS.setAttribute(new Attribute("PLANTILLA", "RelCol.swf"));
            Document doc = new Document(RELACION_DE_COLUMNAS);

            Element PREGUNTA = new Element("PREGUNTA");
            PREGUNTA.setAttribute(new Attribute("TEXTO", pregunta.getTitulo()));
            PREGUNTA.setAttribute(new Attribute("RESPUESTA", pregunta.getRespcol()));
            
            Element DRAGS = new Element("DRAGS");
            for(String s:pregunta.getPregunta()){
                Element OPCION = new Element("OPCION");
                OPCION.setText(s);
                DRAGS.addContent(OPCION);
            }
            PREGUNTA.addContent(DRAGS);
            
            Element TARGETS = new Element("TARGETS");
            for(String s:pregunta.getRespuesta()){
                Element OPCION = new Element("OPCION");
                OPCION.setText(s);
                TARGETS.addContent(OPCION);
            }
            
            PREGUNTA.addContent(TARGETS);
            
            doc.getRootElement().addContent(PREGUNTA);
            // new XMLOutputter().output(doc, System.out);
            XMLOutputter xmlOutput = new XMLOutputter();
            // display nice nice
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter(Path + ID + Num + ".xml"));
            System.out.println("Multiple CHOICE saved file:" + Path + ID + Num + ".xml");
            return ID + Num + ".xml";
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    private String GuardarPreguntaAutocomplete(String Path, PreguntaProfesor pregunta, int Num, String ID) {
        try {
            Element AUTOCOMPLETE = new Element("AUTOCOMPLETE");
            AUTOCOMPLETE.setAttribute(new Attribute("PLANTILLA", "autocomplete.swf"));
            AUTOCOMPLETE.setAttribute(new Attribute("TEXTO1", pregunta.getPregunta().get(0)));
            AUTOCOMPLETE.setAttribute(new Attribute("TEXTO2", pregunta.getPregunta().get(1)));
            AUTOCOMPLETE.setAttribute(new Attribute("RESPUESTA", pregunta.getRespuesta().get(0)));
            Document doc = new Document(AUTOCOMPLETE);

            // new XMLOutputter().output(doc, System.out);
            XMLOutputter xmlOutput = new XMLOutputter();
            // display nice nice
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter(Path + ID + Num + ".xml"));
            System.out.println("Autocomplete saved file:" + Path + ID + Num + ".xml");
            return ID + Num + ".xml";
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Crea los dialogos
     * @param Path
     * @param conver
     * @param Pagina
     * @param PaginaSiguiente 
     */
    private void CrearDialogos(String Path, String[] conver, String Pagina, String PaginaSiguiente) {
        new xhtmlConversacion(conver, PaginaSiguiente, Path, Pagina).Guardar();
    }
}
