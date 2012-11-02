<%-- 
    Document   : EliminaMatricula
    Created on : 21/10/2012, 10:10:19 PM
    Author     : IPNWIN
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link href="Estilos/estilo-general.css" rel="stylesheet" type="text/css" />
        <link href="Estilos/estilo-menu.css" rel="stylesheet" type="text/css" />
    </head>
    <body class="body">
        <div align="center">
            <s:form action="EliminarM" method="POST">       
                <s:textfield name="Matricula" label="Matricula de usuario a eliminar" />
                <s:submit value="Eliminar" />
            </s:form>
            <s:label value="%{Mensaje}"></s:label>
        </div>
    </body>
</html>

