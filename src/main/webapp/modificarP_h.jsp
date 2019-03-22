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
        <jsp:param name="title" value="Modificar Paciente" />
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
                    <form class="form" action="restP/patient/addPatient" method="post">
                        <h4>Modificar Paciente</h4>
                        <label>Nombre:
                            <input type="number" value="<%=request.getParameter("pId")%>" style="display:none" name="pId">
                            <input id="nombreP" type="text" placeholder="Coloque el nombre del paciente" name="nameP" required>
                        </label>
                        <label>Apellido: 
                            <input id="apellidoP" type="text" placeholder="Coloque el apellido del paciente" name="lastNameP" required>
                        </label>
                        <label>Direccion: 
                            <input id="dir" type="text" placeholder="Coloque el nombre la direccion del paciente" name="dir" required>
                        </label>
                        <label>Telefono: 
                            <input id="tel" type="number" placeholder="Coloque el telefono del paciente" name="tel" required>
                        </label>
                        <label>Fecha de nacimiento: 
                            <input id="fNac" type="date" name="bDate" required>
                        </label>
                        <label>DPI: 
                            <input id="dpi" type="number" placeholder="Coloque el dpi del paciente" name="dpi" required>
                        </label>
                        <label>Numero de seguro: 
                            <input id="segNum" type="number" placeholder="Coloque el numero de seguro del paciente" name="segNum">
                        </label>
                        <label>Doctor de cabecera: 
                            <select id="doctoresData" name="docId">
                            </select>
                        </label>
                        <br>
                        <input type="submit" class="cell button medium-8" value="Modificar">
                    </form>
                </div>
            </div>
        </div>
    </body>
    <script src="js/docInf.js"></script>
    <script src="js/patientModInf.js"></script>
</html>
