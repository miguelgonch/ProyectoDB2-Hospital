<%-- 
    Document   : crudHospital
    Created on : Mar 11, 2019, 11:39:34 AM
    Author     : manu
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Actualización usuario" />
    </jsp:include>
    <body>
         <div class="grid-container">
        <div class="grid-x grid-margin-x align-center">
            
            
            <form class="cell small-12 medium-8" action="updateUser_h" method="post" <!--enctype="multipart/form-data"--> >
                <h4 class="text-center">Panel para actualización de datos</h4>
                
                <input type="hidden" name="id_usuario" value="<%= request.getParameter("user_id") %>">
                <input type="hidden" name="hospNum" value="<%= request.getParameter("hospitalNum") %>">
                username:<br>
                <input type="text" name="usuario" value="" placeholder="Ingrese aqui el username">
                <br> Nombre:<br>
                <input type="text" name="nombre" value="" placeholder="Ingrese aqui el nombre">
                <br> Apellido
                <br>
                <textarea type="text" name="apellido" value="" placeholder="Ingrese aqui el apellido"></textarea>
                <br> Teléfono de contacto:<br>
                <input type="text" name="telefono" value="" placeholder="ej: 54638126" pattern="[0-9]+">
                <br> Especialidad
                <br>
                <select name="especialidad">
                    <optgroup label=categoria1><option value=1>onto</option><option value=2>pedia</option><optgroup label=categoria2><option value=4>neuro</option><option value=5>cardio</option><option value=6>general</option><option value=7>enfermera</option>            </select>
                <br> Tipo de usuario
                <br>
                <select name="tipodeusuario">
                    <option value=1>admin</option><option value=2>asistente</option><option value=3>algo</option></select>
                
                <br>
                <input class="button small-12 cell" type="submit" name="submit" value="Actualizar" />
            </form>
                
                <form class="cell small-12 medium-8" action="deleteUser_h" method="post" <!--enctype="multipart/form-data"-->>
                   
                    <input type="hidden" name="id_usuario" value="<%= request.getParameter("user_id") %>">
                    <input type="hidden" name="hospNum" value="<%= request.getParameter("hospitalNum") %>">
                    <input class="button small-12 cell" type="submit" name="submit" value="Borrar usuario" />
                    
                </form>
                
                
        </div>
    </div>
    </body>
</html>

















