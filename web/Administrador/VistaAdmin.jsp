<%-- 
    Document   : VistaAdmin
    Created on : 29/10/2012, 09:39:06 PM
    Author     : IPNWIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Modulo Administrador English Voice</title>
       <link href="Estilos/estilo-general.css" rel="stylesheet" type="text/css" />
         <%--<link href="Estilos/estilo-menu.css" rel="stylesheet" type="text/css" />--%>
        <script type="text/javascript" src="../Estilos/jquery-1.8.s2.min.js">           
        </script>

        <script type="text/javascript" src="../Estilos/jqueryvalidator.js"></script>

        <script type="text/javascript">
            //<![CDATA[


            function cargaURL(url, titulo)
            {
                window.frames['marco-desplegado'].location = url;
                document.getElementById("titulo").innerHTML = titulo;
            }


            //]]>
        </script>
    </head>

    <body onload="cargaURL('Administrador/Welcome.jsp','Modulo Administrador')">
        <!-- Encabezado -->

        <div class="titulo" id="titulo"></div>

        <div class="encabezado"></div><!-- El menu -->

        <div class="menu-izquierdo">
           
            <h5> <s:label value="Bienvenido %{Nombre}"></s:label></h5>
            <h5> <s:label value="Matricula: %{Matricula}"></s:label></h5>
            <h2>Menu Principal</h2>
            <table class="menu-principal">
                <tr>
                    <td class="item" onClick="cargaURL('Administrador/Welcome.jsp','Modulo Administrador')">Introducción</td>
                </tr>
                <tr>
                    <td class="item" onClick="cargaURL('Administrador/Inserta.jsp','Insertar')">Insertar</td>
                </tr>
                <tr>
                    <td class="item" onClick="cargaURL('listarInicio','Mostrar')">Mostrar</td>
                </tr>
                <tr>
                    <td class="item" onClick="cargaURL('Administrador/OpcionEliminar.jsp','Eliminar')">Eliminar</td>
                </tr>
                <tr>
                    <td class="item" onClick="cargaURL('Administrador/Modifica.jsp','Modificar')">Modificar</td>
                </tr>
                <tr>
                    <td></td>
                </tr>


            </table>

            <s:form action="cerrarSesion" method="POST">
                <s:submit align="center" value="Cerrar Sesion"></s:submit>
            </s:form>          
        </div><!-- Area de desplegado -->
        <iframe class="area-desplegado" id="marco-desplegado" name="marco-desplegado" frameborder="0"></iframe>
    </body>
</html>

