<%-- 
    Document   : exitoAdminC
    Created on : 03.03.2019, 15:19:07
    Author     : C.V
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Exito Admin clientes" />
    </jsp:include>
    <%@ include file="partials/_headerLogged.jsp"%>
    <body>
        <h1>Exito Administracion de clientes!</h1>
        <a href="clienteNuevo.jsp"> Registrar Cliente<a/>
        <br>
        <a href="modificarCliente0.jsp"> Modificar Cliente<a/> 
        <br>
        <a href="eliminarCliente.jsp"> Eliminar Cliente<a/>    
    </body>
</html>




