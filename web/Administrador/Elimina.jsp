<%-- 
    Document   : Elimina
    Created on : 17/10/2012, 07:04:20 PM
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
<%--        <div align="right">

            <s:form action="cerrarSesion" method="POST">
                <s:submit value="Cerrar Sesion"></s:submit>
            </s:form>
        </div>
--%>>

        
        <div align="center">
            <s:form action="Eliminar" method="POST">       
                <s:textfield name="Nombre" label="Nombre de usuario a Eliminar" />
                <s:submit value="Eliminar" />
            </s:form>
            <s:label value="%{Mensaje}"></s:label>
                    <%--<s:form action="regresar" method="POST">
                <s:submit value="Regresar"></s:submit>
              </s:form>--%>
        </div>
    </body>
</html>
