<%-- 
    Document   : addUser_h
    Created on : Mar 11, 2019, 11:39:34 AM
    Author     : manu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--head-->
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Agregar Usuario" />
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
                    <form class="form" action="restU/usuarios/addUsuarios" method="post">
                        <h4>Agregar Usuario</h4>
                        <label>Username 
                            <input type="text" placeholder="Coloque el username del usuario" name="username" required>
                        </label>
                        <label>Contrasenia 
                            <input type="text" placeholder="Coloque la contrasenia del usuario" name="passw" required>
                        </label>
                        <label>Nombre: 
                            <input type="text" placeholder="Coloque el nombre del usuario" name="name" required>
                        </label>
                        <label>Apellido: 
                            <input type="text" placeholder="Coloque el apellido del usuario" name="lastName" required>
                        </label>
                        <label>Telefono: 
                            <input type="number" placeholder="Coloque el telefono del usuario" name="tel" required>
                        </label>
                          
                        <label>Especialidad: 
                            <select id="especialidadData" name="usSpecial">
                            </select>
                        </label>
                        <label>Tipo de usuario:
                            <select id="typeData" name="usType">
                            </select>
                        </label> 
                      
                        <input type="submit" class="cell button medium-8" value="Agregar">
                    </form>
                </div>
            </div>
        </div>
    </body>
    <script src="js/especialidadInf.js"></script>
    <script src="js/typeInf.js"></script>
</html>


























