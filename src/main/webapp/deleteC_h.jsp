<%-- 
    Document   : aggregarP_h
    Created on : Mar 12, 2019, 12:41:02 AM
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--head-->
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Eliminar Cita" />
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
                    <h4>¿Eliminar Cita?</h4>
                    <div class="cell small-10 medium-12">
                        <div id="historialData">
                        </div>
                    </div>
                    <form class="form" action="restC/cita/deleteCita" method="post">
                        <input type="number" value="<%=request.getParameter("citaId")%>" style="display:none" name="delId">
                        <input type="submit" class="cell button medium-8" value="Eliminar">
                        <a class="button expanded" href="citas_h.jsp">Cancelar</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
    <script src="js/infoCitas.js"></script>
    </html>
