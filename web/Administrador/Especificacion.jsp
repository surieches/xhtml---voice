
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


        <script>
            $(document).ready(function(){
                $("#validar").validate({
                    rules:{
                        curp:{
                            required:true
                        },
                        f_nac:{
                            required:true
                        },  
                        calle:{
                            required:true
                        },
                        num:{
                            required:true
                          
                        }, 
                        col:{
                            required:true
                        },  
                        del:{
                            required:true
                        }
                        ,  
                        pais:{
                            required:true
                        },
                        Email:{
                            required:true,
                            email:true
                        }
                    },
                    messages:{
                        
                        
                        
                    }

                });
            });
        </script>
    </head>
    <body class="body">

        <div id="container">
            <s:form action="agregarEs" method="POST" id="validar">

                <h1>  Insertar</h1>

                <s:textfield name="Matricula" label="Matricula asignada"/>

                <s:textfield id="curp" name="CURP" label="C.U.R.P."/>
                <s:textfield id="f_nac" name="Fecha_nac" label="Fecha de nacimiento"/>
                <s:textfield id="calle" name="Calle" label="Calle"/>
                <s:textfield id="num" name="Numero" label="Numero"/>
                <s:textfield id="col" name="Colonia" label="Colonia"/>
                <s:textfield id="del" name="Delegacion" label="Delegación"/>
                <s:textfield id="pais" name="Pais" label="País"/>
                <s:textfield id="Email" name="Email" label="E-Mail"/>
                <s:submit value="Guardar"/>
            </div>
            <div></div>
        </s:form>

    </body>

</html>