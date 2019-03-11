<%-- 
    Document   : pacienteNuevo
    Created on : 10.03.2019, 18:30:43
    Author     : C.V
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
      <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Nuevo Paciente" />
    </jsp:include>
    <body>
        <div class="grid-container">
            <div class="grid-x grid-margin-x align-center">
                <form class="cell small-12 medium-8" action="nuevoCliente" method="post">
                    <h4 class="text-center">Ingrese los datos del nuevo paciente</h4>
                    Tipo de Poliza:<br>
                    <select name="tPoliza">
                        <option value="normal">Normal</option><option value="premium">premium</option>
                    </select>
                    <br>
                    <br> Nombre del Cliente:<br>
                    <input type="text" name="nombre" value="" placeholder="Ingrese el nombre del Cliente">
                    <br> Apellido:
                    <br>
                    <input type="text" name="apellido" value="" placeholder="Ingrese el apellido del Cliente">
                    <br> Telefono:<br>
                    <input type="text" name="telefono" value="" placeholder="ingrese el numero de telefono del Cliente">
                    <br> e-mail:<br>
                    <input type="text" name="email" value="" placeholder="ingrese el correo electronico del Cliente">
                    <br> documento de identificacion del cliente:<br>
                    <input type="text" name="doc" value="" placeholder="Ingrese el numero de identificacion del cliente">
                    <br> contacto de emergencia:<br>
                    <input type="text" name="contactoE" value="" placeholder="ingreseel nombre de la persona a contactar en caso de emergencia">
                    <br> Telefono del contacto de emergencia:<br>
                    <input type="text" name="telEm" value="" placeholder="ingrese datos tecnicos del producto">
                    <input class="button small-12 cell" type="submit" name="submit" value="Agregar Cliente" />
                </form>
            </div>
        </div>
    </body>
</html>
