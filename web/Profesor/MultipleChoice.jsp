<%-- 
    Document   : MultipleChoice
    Created on : Oct 16, 2012, 2:44:10 PM
    Author     : Maximus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Multiple Choice</title>
    </head>
    <body>
        <h1>Multiple Choice!</h1>
        <s:form action="GuardarPregunta" namespace="/Profesor">
            <s:textfield name="TextoPregunta" label="Pregunta"/>
            <s:textfield name="preguntas_M" label="Respuesta 1"/>
            <s:textfield name="preguntas_M" label="Respuesta 2"/>
            <s:textfield name="preguntas_M" label="Respuesta 3"/>
            <s:textfield name="preguntas_M" label="Respuesta 4"/>
            <s:textfield name="preguntas_M" label="Respuesta 5"/>
            
            <s:radio name="Respuesta" list="#'1':'Respuesta 1','2':'Respuesta 2','3':'Respuesta 3','4':'Respuesta 4','5':'Respuesta 5'" value="1" />
            <s:submit value="Agregar"/>
        </s:form>
    </body>
</html>
