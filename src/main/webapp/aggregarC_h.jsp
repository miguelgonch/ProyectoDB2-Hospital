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
        if(rol.equals("1")||(rolNum<=4)){
        }
        else{
            response.sendRedirect("home_h.jsp");
        }
    %>
    <body>
        <div class="grid-container">
            <div class="grid-x align-center-middle">
                <div class="cell small-10 medium-8">
                    <form class="form" action="/proyectoDB2-Hospital1/verificarC_h.jsp" method="get">
                        <h4>Nueva Cita</h4>
                        <label>Paciente: 
                            <select id="patients" name="pId" required>
                            </select>
                        </label>
                        <label>Fecha: 
                            <input id="fecha" type="date" name="fechaCita" required>
                        </label>
                        <label>Doctor / Encargado: 
                            <select id="doctoresData" name="docId" required>
                            </select>
                        </label>
                        <label>Servicio: 
                            <select id="serviciosData" name="servicioId" required>
                            </select>
                        </label>
                        <label>Hora: 
                            <select id="horariosData" name="hora" required>
                            </select>
                        </label>
                        <br>
                        <input type="submit" class="cell button medium-8" value="Agregar">
                    </form>
                    <a href="home_h.jsp" class="button expanded">Cancelar</a>
                </div>
            </div>
        </div>
    </body>
    <script type="text/javascript" src="js/docInf.js"></script>
    <script type="text/javascript" src="js/horarioInf.js"></script>
    <script type="text/javascript" src="js/serviciosList.js"></script>
    <script type="text/javascript" src="js/patientsList.js"></script>
</html>
