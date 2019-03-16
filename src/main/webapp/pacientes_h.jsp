<%-- 
    Document   : pacientes_h
    Created on : Mar 10, 2019, 8:36:30 PM
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--head-->
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Pacientes" />
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
                    <h1>Pacientes</h1>
                    <a class="button" href="aggregarP_h.jsp">Agregar paciente</a>
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Telefono</th>
                                <th>DPI</th>
                                <th>Numero de seguro</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        <tbody id="patientData">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
    <script src="js/patients.js"></script>
</html>
