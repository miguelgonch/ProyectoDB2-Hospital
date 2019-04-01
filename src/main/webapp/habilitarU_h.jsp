<%-- 
    Document   : aggregarP_h
    Created on : Mar 12, 2019, 12:41:02 AM
    Author     : manu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--head-->
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Habilitar Usuario" />
    </jsp:include>
    
    <!--navbar logged-->
    <%@ include file="partials/_headerLogged.jsp"%>
    
    <!--Verify if the user has access-->
    <%@ include file="partials/_getInfo.jsp"%>
    <%
        if(rol.equals("1")||rol.equals("1")){
        }
        else{
            response.sendRedirect("home_h.jsp");
        }
    %>
    
    <body>
        <div class="grid-container">
            <div class="grid-x align-center-middle">
                <div class="cell small-10 medium-8">
                    <h4>Habilitar Usuario?</h4>
                    <table>
                        <tbody>
                            <tr>
                                <td id="nombreP">Nombre: </td>
                                <td id="apellidoP">Apellido: </td>
                            </tr>
                            <tr>
                                <td id="uTy">Tipo Usuario: </td>
                                <td id="uSpe">Especialidad </td>
                            </tr>
                            <tr>
                                <td id="tel">Telefono: </td>
                                <td id="user">Username: </td>
                            </tr>
                            
                        </tbody>
                    </table>
                    <form class="form" action="restU/usuarios/readdUsuario" method="post">
                        <input type="number" value="<%=request.getParameter("uId")%>" style="display:none" name="delId">
                        <input type="submit" class="cell button medium-8" value="Habilitar">
                        <a class="button expanded" href="usuarios_h.jsp">Cancelar</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
    <script src="js/userInfo.js"></script>
    </html>


