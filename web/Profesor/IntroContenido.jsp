<%-- 
    Document   : IntroContenido
    Created on : Oct 16, 2012, 1:20:33 PM
    Author     : Maximus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Content</title>
        <link href="Estilos/vista.css" rel="stylesheet" type="text/css">
    </head>
    <body class="body">
        <div id="contenedor">
            <div id="cabecera">
        <h1><s:label value="Hello Teacher %{Nombre}!"></s:label></h1>
            <div align="right">
                <s:form action="cerrarSesion" method="POST">
                <s:submit align="center" value="Close Session"></s:submit>
            </s:form>
            </div>
            </div>
        <h1>Write the Introduction for the year</h1>
        <br/>
        
        <s:form action="/Profesor/CrearGrammar" method="POST">
            <s:textarea  name="Intro" cols="100" rows="30"></s:textarea>
            <s:submit value="Siguiente"/>
        </s:form>
        </div>
    </body>
</html>
