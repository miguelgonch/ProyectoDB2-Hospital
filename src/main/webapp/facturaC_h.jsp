<%-- 
    Document   : facturaC_h
    Created on : Apr 21, 2019, 3:29:52 PM
    Author     : C.V
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--head-->
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Factura" />
    </jsp:include>
    <!--navbar logged-->
    <%@ include file="partials/_headerLogged.jsp"%>
    <!--Verify if the user has access-->
    <%@ include file="partials/_getInfo.jsp"%>
    <%
        if(rol.equals("1")||(rolNum<=3)){
            
        }
        else{
            response.sendRedirect("home_h.jsp");
        }
    %>
    <body>
        <div class="grid-container">
            <div class="grid-x align-center">
                <div class="cell small-10 medium-12">
                    <h1>Factura:</h1>
                    <h1 id="facuraInex"></h1>
                    <table>
                        <tbody>
                            <tr>
                                <td id="noFac">Numero de factura: </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td id="cita">Numero de cita: </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td id="seg">Seguro: </td>
                                <td id="noAuth">Autorizacion: </td>
                            </tr>
                            <tr>
                                <td id="fecha">fecha: </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td id="nombre">Nombre: </td>
                            </tr>
                            <tr>
                                <td id="serv">Servicio: </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td id="costo">Costo: </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td id="cob">Cubierto por el seguro: </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td id="pago">Pago por parte del cliente: </td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
    <script src="js/Factura.js"></script>
</html>
