<%-- 
    Document   : eliminarCliente
    Created on : 11.03.2019, 10:33:29
    Author     : C.V
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Eliminar Cliente" />
    </jsp:include>
    <%@ include file="partials/_headerLogged.jsp"%>
    <body>
        <div class="grid-container">
            <div class="grid-x grid-margin-x align-center">
                <form class="cell small-12 medium-8" action="eliminarCliente" method="post">
                    <h4 class="text-center">Ingrese la poliza del cliente a eliminar</h4>
                    poliza:<br>
                    <input type="text" name="poliza" value="" placeholder="Ingrese el numero de poliza del cliente">
                    <br>
                    <input class="button small-12 cell" type="submit" name="submit" value="Eliminar Cliente" />
                </form>
            </div>
        </div>
    </body>
</html>
