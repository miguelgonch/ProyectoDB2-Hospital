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
                                             
                        <br> 
                        <label>Especialidad
                            <br>
                            <select name="usSpecial">
                                <optgroup label=categoria1><option value=1>onto</option><option value=2>pedia</option><optgroup label=categoria2><option value=4>neuro</option><option value=5>cardio</option><option value=6>general</option><option value=7>enfermera</option>            </select>
                        </label>
                            <br> 
                            <label>Tipo de usuario
                            <br>
                            <select name="usType">
                                <option value=1>admin</option><option value=2>asistente</option><option value=3>algo</option></select>
                            </label>
                        <input type="submit" class="cell button medium-8" value="Agregar">
                    </form>
                </div>
            </div>
        </div>
    </body>
    
</html>












