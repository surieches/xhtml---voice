<%-- 
    Document   : Exito
    Created on : 17/10/2012, 09:24:39 PM
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
        <h1>Registro insertado con exito</h1>

        <s:label value="Diste de alta a %{Nombre} como "></s:label>
        <s:set name="webFramework" value="%{Tipo}"/>

        <s:if test="%{#webFramework==0}">
            Alumno
        </s:if>
        <s:elseif test="%{#webFramework==1}">
            Profesor
        </s:elseif>
        <s:elseif test="%{#webFramework==2}">
            Administrador
        </s:elseif>
        <s:else>
            Otro
        </s:else>
        <%--<s:form action="regresar" method="POST">
                <s:submit value="Regresar"></s:submit>
              </s:form>--%>

    </body>
</html>
