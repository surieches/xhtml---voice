<<<<<<< HEAD
<%-- 
    Document   : index
    Created on : Oct 15, 2012, 8:16:47 PM
    Author     : Maximus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="Estilos/style.css" rel="stylesheet" type="text/css">

    <body class="body">
        <div id="fb-root"></div>
        <script>(function(d, s, id) {
            var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id)) return;
            js = d.createElement(s); js.id = id;
            js.src = "//connect.facebook.net/es_LA/all.js#xfbml=1";
            fjs.parentNode.insertBefore(js, fjs);
        }(document, 'script', 'facebook-jssdk'));</script>

        <div id="header">
            <h1><center>ENGLISH VOICE SYSTEM</center></h1>
            <div align="right">
                <s:form action="Login" method="POST">
                    <h2>Login</h2>
                    <s:textfield name="Matricula" label="Matricula" />
                    <s:password name="Password" label="Password" />
                    <s:submit  value="Entrar" />
                </s:form>
                <s:label value="%{Mensaje}"></s:label>
                <a href="AlumnoRegistro.jsp">¿Aún no te has registrado?</a><br>
                <div class="fb-like" data-href="http://www.facebook.com/pages/EnglishVoice/510195475671406" data-send="true" data-layout="box_count" data-width="1000" data-show-faces="true" data-font="arial"></div>
            </div>
        </div>

        <div class="rhm1">
            <div class="rhm1-right"></div>
            <div class="rhm1-left"></div>
            <div class="rhm1-bg">
                <ul>
                    <li class="current"><a href="#"><span>Home</span></a></li>
                    <li><a href="#"><span>About Us</span></a></li>
                    <li><a href="#"><span>Manual</span></a></li>	
                    <li><a href="#"><span>Help</span></a></li>		
                    <li><a href="#"><span>Contact Us</span></a></li>
                    <li><a href="#"><span>News</span></a></li>
                </ul>
            </div>
        </div>
        <div id="gallery">
            <div id="top-photo">
                <marquee behavior="alternate">
                    <img src="images/img08.jpg" alt="Voce" width="950" height="320" />
                    <img src="images/voice03.jpg" alt="Voice2" width="950" height="320" />
                    <img src="images/voice02.jpg" alt="Voice3" width="950" height="320" />
                    <img src="images/img009.jpg" alt="voice4" width="950" height="320" />

                </marquee>
            </div>

            <div id="pie">
                <h2>News <span>Contents</span></h2>


                <div id="fotos">

                    <div id="foto1">fotografia 1</div>
                    <div id="foto2">fotografia 2</div>
                    <div id="foto3">fotografia 3</div>
                    <div id="foto4">fotografia 4</div>
                </div>
            </div>
            <div id="down">
                <p>English Voice 2012</p>
            </div>
    </body>
=======
<%-- 
    Document   : index
    Created on : Oct 15, 2012, 8:16:47 PM
    Author     : Maximus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="Estilos/style.css" rel="stylesheet" type="text/css">
        
    <body class="body">
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/es_LA/all.js#xfbml=1";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>

	<div id="header">
            <h1><center>ENGLISH VOICE SYSTEM SEGUNDO CAMBIO</center></h1>
   <div align="right">
        <s:form action="Login" method="POST">
            <h2>Login</h2>
            <s:textfield name="Matricula" label="Matricula" />
            <s:password name="Password" label="Password" />
            <s:submit  value="Entrar" />
        </s:form>
        <s:label value="%{Mensaje}"></s:label>
        <a href="AlumnoRegistro.jsp">¿Aún no te has registrado?</a><br>
        <div class="fb-like" data-href="http://www.facebook.com/pages/EnglishVoice/510195475671406" data-send="true" data-layout="box_count" data-width="1000" data-show-faces="true" data-font="arial"></div>
        </div>
        </div>

        <div class="rhm1">
<div class="rhm1-right"></div>
<div class="rhm1-left"></div>
<div class="rhm1-bg">
<ul>
	<li class="current"><a href="#"><span>Home</span></a></li>
	<li><a href="#"><span>About Us</span></a></li>
	<li><a href="#"><span>Manual</span></a></li>	
	<li><a href="#"><span>Help</span></a></li>		
	<li><a href="#"><span>Contact Us</span></a></li>
        <li><a href="#"><span>News</span></a></li>
</ul>
</div>
</div>
        <div id="gallery">
	<div id="top-photo">
		<marquee behavior="alternate">
		<img src="images/img08.jpg" alt="Voce" width="950" height="320" />
		<img src="images/voice03.jpg" alt="Voice2" width="950" height="320" />
		<img src="images/voice02.jpg" alt="Voice3" width="950" height="320" />
                <img src="images/img009.jpg" alt="voice4" width="950" height="320" />
                
		</marquee>
	</div>
    
            <div id="pie">
                <h2>News <span>Contents</span></h2>
            
                        
                <div id="fotos">
                
                    <div id="foto1">fotografia 1</div>
                    <div id="foto2">fotografia 2</div>
                    <div id="foto3">fotografia 3</div>
                    <div id="foto4">fotografia 4</div>
                </div>
            </div>
            <div id="down">
                <p>English Voice 2012</p>
            </div>
    </body>
>>>>>>> SEGUNDO
</html>