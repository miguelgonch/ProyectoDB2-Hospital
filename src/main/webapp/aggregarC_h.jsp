<%-- 
    Document   : aggregarP_h
    Created on : Mar 12, 2019, 12:41:02 AM
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--head-->
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Nueva Cita" />
    </jsp:include>
    <!--navbar logged-->
    <%@ include file="partials/_headerLogged.jsp"%>
    <!--Verify if the user has access-->
    <%@ include file="partials/_getInfo.jsp"%>
    <%
        if(rol.equals("1")||(rolNum<=3)){
        }
        else{
            response.sendRedirect("home_h.jsp");
        }
    %>
    <body>
        <div class="grid-container">
            <div class="grid-x align-center-middle">
                <div class="cell small-10 medium-8">
                    <form class="form" action="AddCita" method="post">
                        <h4>Nueva Cita</h4>
                        <label>Paciente: 
                            <select id="patients" name="pId" required>
                            </select>
                        </label>
                        <label>Fecha: 
                            <input type="date" name="fechaCita" required>
                        </label>
                        <label>Hora: 
                            <select id="horariosData" name="hora" required>
                            </select>
                        </label>
                        <label>Servicio: 
                            <select id="serviciosData" name="servicioId" required>
                            </select>
                        </label>
                        <label>Doctor / Encargado: 
                            <select id="doctoresData" name="docId" required>
                            </select>
                        </label>
                        <br>
                        <input type="submit" class="cell button medium-8" value="Agregar">
                    </form>
                </div>
            </div>
        </div>
    </body>
    <script src="js/docInf.js"></script>
    <script src="js/horarioInf.js"></script>
    <script src="js/serviciosList.js"></script>
    <script src="js/patientsList.js"></script>
</html>
