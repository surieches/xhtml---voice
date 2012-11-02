<%-- 
    Document   : Inicio
    Created on : Oct 15, 2012, 10:27:43 PM
    Author     : Maximus
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menú</title>
         <link href="Estilos/estilo1.css" rel="stylesheet" type="text/css">
    </head>
    <body class="body">
        <div align="right">
            <s:label value="Bienvenido %{Nombre} Matricula %{Matricula}"></s:label>
            <s:form action="cerrarSesion" method="POST">
                <s:submit value="Cerrar Sesion"></s:submit>
            </s:form>
        </div>
        <h1 align="center">Menú Administrador XD</h1>


        <div align="center"><a href="agregarInicio">Agregar</a><br/>
            <a href="listarInicio">Listar</a><br/>
            <a href="eliminarInicio">Eliminar</a> <br/>
            <a href="modInicio">Modificar</a> <br/> 
         
         
        </div>
    </body>
</html>