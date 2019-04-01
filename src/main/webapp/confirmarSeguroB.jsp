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
        <jsp:param name="title" value="Citas" />
    </jsp:include>
    <!--navbar logged-->
    <%@ include file="partials/_headerLogged.jsp"%>
    <!--Verify if the user has access-->
    <%@ include file="partials/_getInfo.jsp"%>
    <%
        if(rol.equals("1")||rol.equals("1")){
            
        }
        else{
            response.sendRedirect("home_h.jsp");
        }
        
    %>
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

