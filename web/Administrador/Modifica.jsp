<%-- 
    Document   : Modifica
    Created on : 17/10/2012, 07:04:44 PM
    Author     : IPNWIN
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>


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
            <s:form action="Actualizar" method="POST" validate="true">

                <h1>Actualiza</h1>


                <s:textfield name="Matricula" label="Matricula actual"/>
                <s:label value="Campos a actualizar"></s:label>
                <s:textfield name="MatriculaNueva" label="Matricula"/> 
                <s:textfield name="Tipo" label="Tipo"/>
                <s:textfield name="Password" label="Password"/>
                <s:textfield name="Nombre" label="Nombre"/>
                <s:textfield name="ApPat" label="Apellido Paterno"/>
                <s:textfield name="ApMat" label="Apellido Materno"/>
                <s:submit value="Actualizar"/>


            </s:form>
        </div>
        <div align="center">
                    <%--<s:form action="regresar" method="POST">
                <s:submit value="Regresar"></s:submit>
              </s:form>--%>
        </div>

    </body>

</html>

