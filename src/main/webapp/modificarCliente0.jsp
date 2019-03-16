<%-- 
    Document   : modificarCliente0
    Created on : 11.03.2019, 11:08:02
    Author     : C.V
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Cliente a Modificar" />
    </jsp:include>
    <body>
        <div class="grid-container">
            <div class="grid-x grid-margin-x align-center">
                <form class="cell small-12 medium-8" action="modificarCliente0" method="post">
                    <h4 class="text-center">Ingrese la poliza del cliente a modificar</h4>
                    Poliza:<br>
                    <input type="text" name="poliza" value="" placeholder="Ingrese la poliza del cliente">
                    <br>
                    <input class="button small-12 cell" type="submit" name="submit" value="Modificar Clliente" />
                </form>
            </div>
        </div>
    </body>
</html>
