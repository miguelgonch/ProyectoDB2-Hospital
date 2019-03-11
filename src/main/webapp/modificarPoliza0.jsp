<%-- 
    Document   : modificarPoliza0
    Created on : 11.03.2019, 15:31:37
    Author     : C.V
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Elegir poliza a modificar" />
    </jsp:include>
    <body>
        <div class="grid-container">
            <div class="grid-x grid-margin-x align-center">
                <form class="cell small-12 medium-8" action="modificarPoliza0" method="post">
                    <h4 class="text-center">Ingrese el nombre de la poliza a modificar</h4>
                    Nombre de poliza:<br>
                    <input type="text" name="nPoliza" value="" placeholder="ej. Premium">
                    <br>
                    <input class="button small-12 cell" type="submit" name="submit" value="Modificar poliza" />
                </form>
            </div>
        </div>
    </body>
</html>
