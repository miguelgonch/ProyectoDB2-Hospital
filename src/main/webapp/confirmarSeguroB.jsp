<%-- 
    Document   : confirmarSeguroB
    Created on : Mar 24, 2019, 5:11:09 PM
    Author     : C.V
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% //String dpi = request.getParameter("dpi"); %>

<html>
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Actualización usuario" />
    </jsp:include>
    <body>
        <h1>Cobertura</h1>
        
        <table>
            <thead>
                <tr>
                    
                    <th>Nombre del Asegurado</th>
                    <th>Apellido del asegurado</th>
                    <th>Tipo de seguro</th>
                    
                </tr>
            </thead>
            <tbody id="consulta">
            </tbody>
        </table>
        
        <!--<div id="consulta">
            
        </div>
        <%//= request.getParameter("dpi") %>
    </body>-->
    <!--<script src="js/patients.js"></script>-->
    <script src="js/confirmarSeguro.js"></script>
</html>
