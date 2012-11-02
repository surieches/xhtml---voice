<%-- 
    Document   : Columns
    Created on : Oct 16, 2012, 2:43:42 PM
    Author     : Maximus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relation Columns</title>
    </head>
    <body>
        <s:form action="GuardarPregunta" namespace="/Profesor">
            <s:textfield name="TextoPregunta" label="Titulo"/>
            <br/>
            <s:textfield name="preguntas_M" label="Pregunta 1"/>
            <s:textfield name="respuestas_M" label="Respuesta 1"/>
            <br/>
            <s:textfield name="preguntas_M" label="Pregunta 2"/>
            <s:textfield name="respuestas_M" label="Respuesta 2"/>
            <br/>
            <s:textfield name="preguntas_M" label="Pregunta 3"/>
            <s:textfield name="respuestas_M" label="Respuesta 3"/>
            <br/>
            <s:textfield name="preguntas_M" label="Pregunta 4"/>
            <s:textfield name="respuestas_M" label="Respuesta 4"/>
            <br/>
            <s:submit value="Agregar"/>
        </s:form>
    </body>
</html>
