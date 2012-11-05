<%-- 
    Document   : CalificacionesVer
    Created on : Nov 5, 2012, 2:16:02 AM
    Author     : Maximus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Qualifications</title>
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
        <h1>Qualifications</h1>
        <table id="tabla" class="display" border="1">
            <thead>
                <tr>
                    <th>Name Group</th>
                    <th>Level</th>
                    <th>Content Name</th>
                    <th>Qualify</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="cals" status="it" var="Group">
                    <tr>
                        <td><s:property value="NombreGrupo"/></td>
                        <td><s:property value="Nivel"/></td>
                        <td><s:property value="NombreContenido"/></td>
                        <td><s:property value="Calificacion"/></td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
        <br/>
        <br/>
        <br/>
        <div id="Mensaje"></div>
        <button onclick="location.href='/TT/Login.action'">Back</button>
    </body>
</html>
