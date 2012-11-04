<%-- 
    Document   : Qualifys
    Created on : Nov 4, 2012, 3:26:41 PM
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
            @import "../Estilos/demo_table.css";
            @import "../Estilos/jquery-ui.css";
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
                    <th>Group</th>
                    <th>Level</th>
                    <th>Content</th>
                    <th>Page</th>
                    <th>Last Name</th>
                    <th>Second Name</th>
                    <th>Name</th>
                    <th>Qualify</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="cals" status="it" var="Group">
                    <tr>
                        <td><s:property value="Nombregrupo"/></td>
                        <td><s:property value="Nivel"/></td>
                        <td><s:property value="NombreContenido"/></td>
                        <td><s:property value="Pagina"/></td>
                        <td><s:property value="Appat"/></td>
                        <td><s:property value="Apmat"/></td>
                        <td><s:property value="AlumnoNombre"/></td>
                        <td><s:property value="Calificacion"/></td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
        <br/>
        <br/>
        <br/>
        <button onclick="location.href='/TT/Login.action'">Regresar</button>
    </body>
</html>
