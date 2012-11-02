<%-- 
    Document   : Inicio
    Created on : Oct 15, 2012, 10:28:00 PM
    Author     : Maximus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
        <link href="Estilos/vista.css" rel="stylesheet" type="text/css">


<div id="google_translate_element"></div><script>function googleTranslateElementInit() { new google.translate.TranslateElement({ pageLanguage: 'es' }, 'google_translate_element');}</script><script src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
        
        <title>Menu Student</title>
    </head>
    
    <body class="body">
        <div id="contenedor">
            <div id="cabecera">
        <h1><s:label value="Hello %{Nombre}!"></s:label></h1>
        <h1>Welcome a English Voice!</h1>
            <div align="right">
                <s:form action="cerrarSesion" method="POST">
                <s:submit align="center" value="Cerrar Sesion"></s:submit>
            </s:form>
            </div>
            </div>
        <div id="principal">
            <div id="izquierda">
                <h2>Students Menu</h2>
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="#">Contents</a></li>
                    <li><a href="#">Evaluation</a></li>
                    <li><a href="#">Help</a></li>
                </ul>
                <p>ESCUELA SUPERIOR DE CÓMPUTO "ENGLISH VOICE 2012"</p>
            </div>
            <div id="central">
                <marquee behavior="alternate">
                    <img src="images/Sistema_EV.jpg">
                </marquee>
                <img class='blImagjtef' src='images/img009.jpg'/>
            </div>
        </div>
                        <div id="pie">
                <p>ESCUELA  SUPERIOR DE COMPUTO-IPN <a href="http://www.escom.ipn.mx">ESCOM</a></p>
            </div>
    </body>
</html>
