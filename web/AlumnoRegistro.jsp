<%-- 
    Document   : AlumnoRegistro
    Created on : Oct 15, 2012, 8:17:16 PM
    Author     : Maximus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="Scripts/jquery-1.8.2.min.js"></script>
        <link href="Estilos/formulario.css" rel="stylesheet" type="text/css">
        <script src="Scripts/jquery-ui.js"></script>
        <link rel="stylesheet" href="Estilos/jquery-ui.css" />
        <title>Register Student</title>
        <script>
            $(function() {
                $( "#fecha" ).datepicker();
            });
        </script>
    </head>
    <body class="body">
        <div id="cabecera">
            <h1><center>REGISTER</center></h1>
        </div>
        <div id="div-regForm">
            <div class="form-title">Sign Up</div>
            <div class="form-sub-title">It´s free and anyone can join</div>
            <s:form action="RegistroAlumno" method="POST">
                <hr>
                <table>
                    <tbody>
                        <tr>
                            <td><s:textfield name="Nombre" label="Nombre" /></td>
                        </tr>
                        <tr>
                            <td><s:textfield name="Appat" label="Appat" /></td>
                        </tr>
                        <tr>
                            <td><s:textfield name="Apmat" label="Apmat" /></td>
                        </tr>
                        <tr>
                            <td><s:textfield name="Fenac" label="Fenac" id="fecha"/></td>
                        </tr>
                        <tr>
                            <td><s:textfield name="Curp" label="Curp" /></td>
                        </tr>
                        <tr>
                            <td><s:textfield name="Calle" label="Calle" /></td>
                        </tr>
                        <tr>
                            <td><s:textfield name="Numero" label="Numero" /></td>
                        </tr>
                        <tr>
                            <td><s:textfield name="Delegacion" label="Delegacion" /></td>
                        </tr>
                        <tr>
                            <td<s:textfield name="Pais" label="Pais" /></td>
                        </tr>
                        <tr>
                            <td><s:textfield name="Email" label="Email" /></td>
                        </tr>
                        <tr>
                            <td><s:password name="Password" label="Password" /></td>
                        </tr>
                        <s:submit value="Enviar" />
                    </s:form>
                </tbody>
            </table>
        </div>
        <div id="pie">
            <p>English Voice 2012</p>
        </div>

    </body>
</html>
