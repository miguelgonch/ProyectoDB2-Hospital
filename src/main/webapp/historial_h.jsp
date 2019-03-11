<%-- 
    Document   : historial_h
    Created on : Mar 4, 2019, 9:46:13 AM
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--head-->
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Historial" />
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
        <h1>Historiales</h1>
        <table>
            <thead>
                <tr>
                    <th>ID Cita</th>
                    <th>Diagnostico</th>
                    <th>Resultados</th>
                    <th>Medicinas</th>
                    <th>Pasos a seguir</th>
                    <th>Observaciones</th>
                    <th>Fecha</th>
                    <th>Doctor</th>
                    <th>Opciones</th>
                </tr>
            </thead>
            <tbody id="historialData">
                
            </tbody>
        </table>
    </body>
    <script src="js/historialJson.js"></script>
</html>