<%-- 
    Document   : ListaUsuarios
    Created on : 21/10/2012, 12:19:46 AM
    Author     : IPNWIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>

        <title>Lista de Usuarios</title>
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

   
    <div align="center">

        <s:form action="Listar" method="POST">
            <s:submit value="Listar Usuarios"></s:submit>
        </s:form>

    </div>


    <table border="1" >
        <tr>
            <td><b>Id</b></td>
            <td><b>Type</b></td>
            <td><b>Name</b></td>
            <td><b>Last Name</b></td>
            <td><b>Mother Name</b></td>
            <td><b>CURP</b></td>
            <td><b>Date</b></td>
            <td><b>Street</b></td>
            <td><b>Number</b></td>
            <td><b>cd</b></td>
            <td><b>Delegation</b></td>
            <td><b>Country</b></td>
            <td><b>E-Mail</b></td>
        </tr>
         
        <s:iterator value="%{listaUsuarios}">
            <tr>
                <td><s:property value="Matricula" /></td>
                <td>
                    <s:set name="TiposUsuario" value="Tipo"/>
                    <s:if test="%{#TiposUsuario==0}">
                        Alumno
                    </s:if>
                    <s:elseif test="%{#TiposUsuario==1}">
                        Profesor
                    </s:elseif>
                    <s:elseif test="%{#TiposUsuario==2}">
                        Administrador
                    </s:elseif>
                    <s:else>
                        Otro
                    </s:else>
                </td>
                <td><s:property value="Nombre" /></td>
                <td><s:property value="ApPat" /></td>
                <td><s:property value="ApMat" /></td>
                <td><s:property value="CURP" /></td>
                <td><s:property value="fecha_nac" /></td>
                <td><s:property value="Calle" /></td>
                <td><s:property value="Numero" /></td>
                <td><s:property value="Colonia" /></td>
                <td><s:property value="Delegacion" /></td>
                <td><s:property value="Pais" /></td>
                <td><s:property value="email" /></td>

            </tr>
        </s:iterator>
    </table>
            <%--<s:form action="regresar" method="POST">
                <s:submit value="Regresar"></s:submit>
              </s:form>--%>

</body>
</html>
