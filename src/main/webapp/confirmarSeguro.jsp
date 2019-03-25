<%-- 
    Document   : confirmarSeguro
    Created on : Mar 24, 2019, 4:58:20 PM
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
                <form class="cell small-12 medium-8" action="ConsultarCobertura0" method="post">
                    <h4 class="text-center">Ingrese el numero de identificacion del cliente a comprobar</h4>
                    Numero de identificacion<br>
                    <input type="text" name="dpi" value="" placeholder="Ingrese la poliza del cliente">
                    <br>
                    <input class="button small-12 cell" type="submit" name="submit" value="Modificar Clliente" />
                </form>
            </div>
        </div>
    </body>
</html>



