<%-- 
    Document   : RegisterToGroup
    Created on : Nov 4, 2012, 11:05:22 PM
    Author     : Maximus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register To Group</title>
        <style type="text/css" title="currentStyle">
            @import "../Estilos/jquery-ui.css";
            @import "../Estilos/demo_table.css";
        </style>
        <script type="text/javascript" language="javascript" src="../Scripts/jquery.js"></script>
        <script type="text/javascript" language="javascript" src="../Scripts/jquery.dataTables.js"></script>
        <script>
            var oTable;
 
            $(document).ready(function() {
                /* Add a click handler to the rows - this could be used as a callback */
                $("#tabla tbody tr").click( function( e ) {
                    if ( $(this).hasClass('row_selected') ) {
                        $(this).removeClass('row_selected');
                    }
                    else {
                        oTable.$('tr.row_selected').removeClass('row_selected');
                        $(this).addClass('row_selected');
                    }
                });
     
                /* Add a click handler for the delete row */
                $('#Actualizar').click( function() {
                    var anSelected = fnGetSelected( oTable );
                    var str="";
                    if ( anSelected.length !== 0 ) {
                        $("td",anSelected[0]).each(function(){
                            if($(this).html().search("<form>") >= 0){
                                console.log("entro");
                                str+=value+",";}
                            else if($(this).html() == "Click to edit"){
                                str+=" ,";
                            }
                            else{
                                //access the value as
                                console.log($(this).html());
                                str+=$(this).html()+",";
                            }

                        });
                        str = str.replace("\n",""); 
                        str = str.substring(0, str.length-1);
                        console.log("La cadena es "+str);
                        $.post("http://localhost:8080/TT/Alumno/RegisterToGroupAlta.action", { foo:str } ,function(data){
                            $("#Mensaje").html(data);
                        });
                        oTable.fnDeleteRow( anSelected[0] );
                    }
                } );
     
                /* Init the table */
                oTable = $('#tabla').dataTable( {
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers"
                });
            } );
 
 
            /* Get the rows which are currently selected */
            function fnGetSelected( oTableLocal )
            {
                return oTableLocal.$('tr.row_selected');
            }
            
        </script>
    </head>
    <body>
        <h1>Register</h1>
        <button id="Actualizar">Register</button>
        <table id="tabla" class="display" border="1">
            <thead>
                <tr>
                    <th>Group ID</th>
                    <th>Name Group</th>
                    <th>Level</th>
                    <th>Last Name</th>
                    <th>Second Name</th>
                    <th>Name</th>
                </tr>
            </thead>
            <tbody>
            <s:iterator value="grupos" status="it" var="Group">
                <tr>
                    <td><s:property value="ID"/></td>
                <td><s:property value="NombreGrupo"/></td>
                <td><s:property value="Nivel"/></td>
                <td><s:property value="Appat"/></td>
                <td><s:property value="Apmat"/></td>
                <td><s:property value="NombreProfesor"/></td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
    <br/>
    <br/>
    <br/>
    <div id="Mensaje"></div>
    <button onclick="location.href='/TT/Login.action'">Regresar</button>
</body>
</html>
