<%-- 
    Document   : Grammar
    Created on : Oct 16, 2012, 2:13:39 PM
    Author     : Maximus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Grammar</title>
    </head>
    <body>
        <s:form action="/Profesor/CrearContenido" method="POST">
            <s:textfield name="grammar" label="grammar" />
            <s:textfield name="grammar" label="grammar" />
            <s:textfield name="grammar" label="grammar" />
            <s:textfield name="grammar" label="grammar" />
            <s:textfield name="grammar" label="grammar" />
            <s:textfield name="grammar" label="grammar" />
            <s:submit value="Siguiente" />
        </s:form>
    </body>
</html>
