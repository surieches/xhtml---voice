<%-- 
    Document   : Inserta
    Created on : 17/10/2012, 07:04:10 PM
    Author     : IPNWIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>

        <title>Insertar Registros</title>
        <link href="Estilos/estilo-general.css" rel="stylesheet" type="text/css" />
        <link href="Estilos/estilo-menu.css" rel="stylesheet" type="text/css" />
        <link href="Estilos/formulario.css" rel="stylesheet" type="text/css" />
        
    </head>
    <body class="body">
        <div align="center">
            <div id="div-regForm">
                <div class="form-title">Sign Up</div>
                <div class="form-sub-title">It´s free and anyone can join</div>
            <s:form action="agregar" method="POST" validate="true">
                <hr>
                <table>
                    <tbody>
                        <tr>
                            <td><s:textfield name="Tipo" label="Tipo" size="30" maxLength="30"/></td>
                        </tr>
                <s:textfield name="Password" label="Password"/>
                <s:textfield name="Nombre" label="Nombre"/>
                <s:textfield name="ApPat" label="Apellido Paterno"/>
                <s:textfield name="ApMat" label="Apellido Materno"/>
                <s:submit id="enviar" value="Guardar"/>
            </s:form>
                    </tbody>
                </table>
            </div>
                     
        <div align="center">
            <s:label value="Ingresar datos personales de usuarios existentes"></s:label>
            <s:form action="especificacionInicio" method="POST">
                <s:submit value="Acceder"></s:submit>
            </s:form>
        </div>

    </body>

</html>
