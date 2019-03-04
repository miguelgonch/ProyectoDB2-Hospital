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
                <h4 class="text-center">Ingresa los datos</h4>
                Usuario:<br>
                <input type="text" name="usuariow" value="" placeholder="Ingrese el nombre de usuario ej. mige97">
                <br> Nombre del Usuario:<br>
                <input type="text" name="nombre" value="" placeholder="Ingrese el nombre del empleado">
                <br> Apellido:
                <br>
                <input type="text" name="apellido" value="" placeholder="Ingrese el apellido del usuario">
                <br> e-mail:<br>
                <input type="text" name="email" value="" placeholder="ingrese datos tecnicos del producto">
                <br> contraseña:<br>
                <input type="text" name="passw" value="" placeholder="Ingrese la contraseña para el usuario">
                <br> Puesto:<br>
                <select name="puesto">
                    <option value="Admin">Admin</option><option value="AdminC">AdminC</option><option value="CallC">CallC</option>
                </select>
                <input class="button small-12 cell" type="submit" name="submit" value="Crear Usuario" />
            </form>
        </div>
    </div>

    </body>
</html>
