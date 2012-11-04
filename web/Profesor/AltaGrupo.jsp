<%-- 
    Document   : AltaGrupo
    Created on : Nov 3, 2012, 11:13:47 AM
    Author     : Maximus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>

<html>
    <head>
        <script src="../Scripts/jquery-1.8.2.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Group</title>
        <script>
            $(function() {
                $('#submitform').click(function() {
                    $.post("InsertarGrupo.action", $("#formA").serialize(),function(data) {
                        $("#principal").html(data);
                    });
                });
            });
        </script>
    </head>
    <body>
        <h1>Register Group!</h1>
        <div id="principal">
            
            <s:form action="InsertarGrupo" namespace="/Profesor" id="formA">
                <s:textfield name="Nombre" label="Nombre"/>
                <s:select name="Nivel" list="#{'1':'Nivel Principiante','2':'Nivel Básico','3':'Nivel Intermedio','4':'Nivel Avanzado','5':'Conversacional'}" value="1" />
            </s:form>
            <button id="submitform">Register Group</button>
            <br/>
            <br/>
            <button onclick="location.href='/TT/Login.action'">Regresar</button>
        </div>
    </body>
</html>
