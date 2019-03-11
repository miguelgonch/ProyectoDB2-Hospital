<%-- 
    Document   : nuevaPoliza
    Created on : 11.03.2019, 14:28:48
    Author     : C.V
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Nueva Poliza" />
    </jsp:include>
    <body>
        <div class="grid-container">
            <div class="grid-x grid-margin-x align-center">
                <form class="cell small-12 medium-8" action="nuevaPoliza" method="post">
                    <h4 class="text-center">Ingrese los datos</h4>
                    Nombre de poliza:<br>
                    <input type="text" name="tipo_poliza" value="" placeholder="Ingrese el nombre de el tipo nuevo de poliza">
                    <br> cobertura:<br>
                    <input type="text" name="cobertura" value="" placeholder="Ingrese la cobertura de la poliza ej. 10%">
                    <br>
                    <input class="button small-12 cell" type="submit" name="submit" value="Crear Poliza" />
                </form>
            </div>
        </div>
    </body>
</html>
