<%-- 
    Document   : FalseTrue
    Created on : Oct 16, 2012, 2:43:17 PM
    Author     : Maximus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>False And True</title>
    </head>
    <body>
        <h1>False True!</h1>
        
        <s:form action="GuardarPregunta" namespace="/Profesor">
            <s:textfield name="TextoPregunta" label="Pregunta"/>
            <s:radio name="Respuesta" list="#'1':'True','2':'False'" value="1" />
            <s:submit value="Agregar"/>
        </s:form>
    </body>
</html>
