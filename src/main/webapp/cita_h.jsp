<%-- 
    Document   : cita_h
    Created on : Mar 11, 2019, 3:21:42 PM
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
        <div class="grid-container">
            <div class="grid-x align-center">
                <div class="cell small-10 medium-12">
                    <h1>Historial:</h1>
                    <table>
                        <tbody id="datosPaciente">

                        </tbody>
                    </table>
                </div>
                <div class="cell small-10 medium-12" id="historialData">
                </div>
            </div>
        </div>
    </body>
    <script src="js/infoCitas.js"></script>
    <script src="js/patientInfo.js"></script>
</html>

