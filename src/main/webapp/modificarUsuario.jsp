<%-- 
    Document   : modificarUsuario
    Created on : 04.03.2019, 00:12:26
    Author     : C.V
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Modificaar Usuario" />
    </jsp:include>
    <body>
        
        <div class="grid-container">
        <div class="grid-x grid-margin-x align-center">
            <form class="cell small-12 medium-8" action="modificarUsuario" method="post">
                <h1>Se modificara el usuario  <%= request.getParameter("usuarioS") %> </h1>
                <h4 class="text-center">Ingresa los datos</h4>
                Usuario:<br>
                <input type="text" name="usuariow" value="<%= request.getParameter("usuarioS") %>" placeholder="Ingrese el nombre de usuario ej. mige97">
                <br> Nombre del Usuario:<br>
                <input type="text" name="nombre" value="<%= request.getParameter("nombreS") %>" placeholder="Ingrese el nombre del empleado">
                <br> Apellido:
                <br>
                <input type="text" name="apellido" value="<%= request.getParameter("apellidoS") %>" placeholder="Ingrese el apellido del usuario">
                <br> e-mail:<br>
                <input type="text" name="email" value="<%= request.getParameter("emailS") %>" placeholder="ingrese datos tecnicos del producto">
                <br> contraseña:<br>
                <input type="text" name="passw" value="<%= request.getParameter("passS") %>" placeholder="Ingrese la contraseña para el usuario">
                <br> Puesto:<br>
                <select name="puesto">
                    <option value="<%= request.getParameter("puestoS") %>">Admin</option><option value="AdminC">AdminC</option><option value="CallC">CallC</option>
                </select>
                <input class="button small-12 cell" type="submit" name="submit" value="Modificar Usuario" />
            </form>
        </div>
    </div>

    </body>
</html>
