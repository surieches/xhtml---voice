<%-- 
    Document   : CrearContenido
    Created on : Oct 16, 2012, 1:11:58 PM
    Author     : Maximus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Contenido</title>
    </head>
    <body>
        <h1><s:label value="Pregunta %{NumPregunta}"></s:label></h1>

        <p>Escoge el tipo de la pregunta</p>

        <s:form action="AgregarPregunta" namespace="/Profesor">
            <s:radio name="TipoPregunta" list="#'1':'Multiple Choice','2':'False or True','3':'Columns Relations','4':'Autocomplete'" value="1" />
            <s:submit value="Agregar"/>
        </s:form>

        <s:if test="%{NumPregunta>1}">
            <s:form action="GuardarContenido" namespace="/Profesor">
                <s:textfield name="NombreContenido" label="Nombre del Contenido"/> 
                <s:submit value="Guardar"/>
            </s:form>
        </s:if>
    </body>
</html>
