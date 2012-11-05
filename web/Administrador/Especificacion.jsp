
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title>Insertar Registros</title>
        <link href="Estilos/estilo-general.css" rel="stylesheet" type="text/css" />
        <link href="Estilos/estilo-menu.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="../Scripts/jquery-1.8.2.min.js">           
        </script>

        <script type="text/javascript" src="../Scripts/jqueryvalidator.js"></script>

        <script src="../Scripts/jquery-ui.js"></script>
        <link rel="stylesheet" href="../Estilos/jquery-ui.css" />
        <script>
            $(function() {
                $( "#fecha" ).datepicker();
            });
        </script>
        <script>
            $(document).ready(function(){
                $("#Validatetu").validate({
                    rules:{
                        CURP:{
                            required:true
                        },
                        /*Fecha_nac:{
                            required:true
                       
                        },  */
                        Calle:{
                            required:true
                        },
                        Numero:{
                            required:true,
                            number:true
                          
                        }, 
                        Colonia:{
                            required:true
                        },  
                        Delegacion:{
                            required:true
                        }
                        ,  
                        Pais:{
                            required:true
                        },
                        Email:{
                            required:true,
                            email:true
                        }
                    }

                });
            });
        </script>
    </head>
    <body class="body">

        <div id="container">
            <s:form action="agregarEs" method="POST" id="Validatetu">

                <h1>  Insertar</h1>

                <s:textfield name="Matricula" label="Matricula asignada"/>
                <s:textfield id="CURP" name="CURP" label="C.U.R.P."/>
                <s:textfield id="fecha" name="Fecha_nac" label="Fecha de nacimiento(dd/mm/aaaa)"/>
                <s:textfield id="Calle" name="Calle" label="Calle"/>
                <s:textfield id="Numero" name="Numero" label="Numero"/>
                <s:textfield id="Colonia" name="Colonia" label="Colonia"/>
                <s:textfield id="Delegacion" name="Delegacion" label="Delegación"/>
                <s:textfield id="Pais" name="Pais" label="País"/>
                <s:textfield id="Email" name="Email" label="E-Mail"/>
                <s:submit align="center" value="Guardar"/>
            </div>
            <div></div>
        </s:form>



    </body>

</html>