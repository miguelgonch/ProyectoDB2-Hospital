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
        <jsp:param name="title" value="Agregar Paciente" />
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
            <div class="grid-x align-center-middle">
                <div class="cell small-10 medium-8">
                    <form class="form" action="AddPatient" method="post">
                        <h4>Agregar Paciente</h4>
                        <label>Nombre: 
                            <input type="text" placeholder="Coloque el nombre del paciente" name="nameP" required>
                        </label>
                        <label>Apellido: 
                            <input type="text" placeholder="Coloque el apellido del paciente" name="lastNameP" required>
                        </label>
                        <label>Direccion: 
                            <input type="text" placeholder="Coloque el nombre la direccion del paciente" name="dir" required>
                        </label>
                        <label>Telefono: 
                            <input type="number" placeholder="Coloque el telefono del paciente" name="tel" required>
                        </label>
                        <label>Fecha de nacimiento: 
                            <input type="date" name="bDate" required>
                        </label>
                        <label>DPI: 
                            <input type="number" placeholder="Coloque el dpi del paciente" name="dpi" required>
                        </label>
                        <label>Numero de seguro: 
                            <input type="number" placeholder="Coloque el numero de seguro del paciente" name="segNum">
                        </label>
                        <label>Doctor de cabecera: 
                            <select id="doctoresData" name="docId">
                            </select>
                        </label>
                        <label>Aseguradora:
                            <select id="asegData" name="asegNum">
                            </select>
                        </label>
                        <label>Tipo de seguro:
                            <select id="typeAseg" name="asegType">
                            </select>
                        </label>
                        <br>
                        <input type="submit" class="cell button medium-8" value="Agregar">
                    </form>
                </div>
            </div>
        </div>
    </body>
    <script src="js/AsegTypeInf.js"></script>
    <script src="js/docInf.js"></script>
    <script src="js/asegInf.js"></script>
</html>


