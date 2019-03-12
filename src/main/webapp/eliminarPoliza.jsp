<%-- 
    Document   : eliminarPoliza
    Created on : 11.03.2019, 15:18:49
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
                <form class="cell small-12 medium-8" action="eliminarPoliza" method="post">
                    <h4 class="text-center">Ingrese el nombre de la poliza a eliminar</h4>
                    poliza:<br>
                    <input type="text" name="nPoliza" value="" placeholder="ej. premium">
                    <br>
                    <input class="button small-12 cell" type="submit" name="submit" value="Eliminar Poliza" />
                </form>
            </div>
        </div>
    </body>
</html>
