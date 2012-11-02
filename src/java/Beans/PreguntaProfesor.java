/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.List;

/**
 *
 * @author Maximus
 */
public class PreguntaProfesor {
    private int Tipo;
    private List<String> Pregunta;
    private List<String> Respuesta;
    private int RespuestaCorrecta;
    private String titulo;
    private String respcol;
    

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

    public List<String> getPregunta() {
        return Pregunta;
    }

    public void setPregunta(List<String> Pregunta) {
        this.Pregunta = Pregunta;
    }

    public List<String> getRespuesta() {
        return Respuesta;
    }

    public void setRespuesta(List<String> Respuesta) {
        this.Respuesta = Respuesta;
    }

    public int getRespuestaCorrecta() {
        return RespuestaCorrecta;
    }

    public void setRespuestaCorrecta(int RespuestaCorrecta) {
        this.RespuestaCorrecta = RespuestaCorrecta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getRespcol() {
        return respcol;
    }

    public void setRespcol(String respcol) {
        this.respcol = respcol;
    }
    
    
    
}
