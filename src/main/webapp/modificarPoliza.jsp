<%-- 
    Document   : modificarPoliza
    Created on : 11.03.2019, 15:30:53
    Author     : C.V
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Modificar Poliza" />
    </jsp:include>
    <body>
        <div class="grid-container">
        <div class="grid-x grid-margin-x align-center">
            <form class="cell small-12 medium-8" action="modificarPoliza" method="post">
                <h4 class="text-center">Ingresa los datos</h4>
                Nombre de la poliza:<br>
                <input type="text" name="nPoliza" value="<%= request.getParameter("nPoliza") %>" placeholder="ej. premium">
                <br> cobertura%:<br>
                <input type="text" name="cobertura" value="<%= request.getParameter("coberturaS") %>" placeholder="ej. 20%">
                <input class="button small-12 cell" type="submit" name="submit" value="Crear Usuario" />
            </form>
        </div>
    </div>
    </body>
</html>
