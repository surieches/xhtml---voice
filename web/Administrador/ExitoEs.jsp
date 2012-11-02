<%-- 
    Document   : ExitoEs
    Created on : 21/10/2012, 04:46:23 PM
    Author     : IPNWIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib uri="/struts-tags" prefix="s"%>
<html>
    <head>

        <title>Insertar Registros</title>
        <link href="Estilos/estilo-general.css" rel="stylesheet" type="text/css" />
        <link href="Estilos/estilo-menu.css" rel="stylesheet" type="text/css" />
    </head>
    <body class="body">
<%--        <div align="right">

            <s:form action="cerrarSesion" method="POST">
                <s:submit value="Cerrar Sesion"></s:submit>
            </s:form>
        </div>
--%>
        <h1>Datos de especificacion insertado con exito</h1>

        <s:label value="Agregaste mas datos con Matricula %{Matricula}"></s:label>
                <%--<s:form action="regresar" method="POST">
                <s:submit value="Regresar"></s:submit>
              </s:form>--%>
    </body>
</html>
