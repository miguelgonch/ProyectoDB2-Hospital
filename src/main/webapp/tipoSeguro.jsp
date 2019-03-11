<%-- 
    Document   : tipoSeguro
    Created on : 11.03.2019, 14:22:20
    Author     : C.V
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="administracion tipos de seguro" />
    </jsp:include>
    <body>
        <h1>Que desea hacer?</h1>
        <a href="nuevaPoliza.jsp">Nueva poliza</a>
        <br>
        <a href="modificarPoliza.jsp">Modificar poliza</a>
        <br>
        <a href="eliminarPoliza.jsp">Eliminar poliza</a>
    </body>
</html>
