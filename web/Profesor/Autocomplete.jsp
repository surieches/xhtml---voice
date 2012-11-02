<%-- 
    Document   : Autocomplete
    Created on : Oct 19, 2012, 1:02:30 AM
    Author     : Maximus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Auto Complete</title>
    </head>
    <body>
        <h1>Autocomplete!</h1>
        
        <s:form action="GuardarPregunta" namespace="/Profesor">
            <s:textfield name="respuestas_M" label="Texto1"/>
            <s:textfield name="respuestas_M" label="Texto 2"/>
            <s:textfield name="respuestas_M" label="Texto 3"/>
            
            <s:submit value="Agregar"/>
        </s:form>
    
    </body>
</html>
