<%-- 
    Document   : CrearConversacion
    Created on : Oct 31, 2012, 12:21:41 PM
    Author     : Maximus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conversation</title>
    </head>
    <body>
        <h1>Conversation!</h1>
        <s:form action="/Profesor/CrearEjercicios" method="POST">
            <s:textfield name="grammar" label="Dialogo 1" />
            <s:textfield name="grammar" label="Dialogo 2" />
            <s:textfield name="grammar" label="Dialogo 1" />
            <s:textfield name="grammar" label="Dialogo 2" />
            <s:textfield name="grammar" label="Dialogo 1" />
            <s:textfield name="grammar" label="Dialogo 2" />
            <s:textfield name="grammar" label="Dialogo 1" />
            <s:submit value="Siguiente" />
        </s:form>
    </body>
</html>
