<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Home" />
    </jsp:include>
    <%@ include file="partials/_headerLogged.jsp"%>
    <%@ include file="partials/_getInfo.jsp"%>
    <body>
        <div class="grid-container">
            <div class="grid-x align-center">
                <div class="cell small-10 medium-12">
                    <h3>Bienvenido </h3>
                    <p>rol <%= Integer.parseInt(rol)%> </p>
                    <p>Hospital # <%= hospitalNum%></p>
                    <a class="button" href="pacientes_h.jsp">Ver pacientes</a>
                    <a class="button" href="citas_h.jsp">Ver Citas</a>
                    </br>
                    <% 
                        if(rolNum<=3){
                            out.println("<a class=\"button\" href=\"confirmarSeguro.jsp\">comprobar seguro</a>");
                        }
                        if(rolNum==1){
                            out.println("<h2>Administracion</h2>"+
                                        "<a class=\"button\" href=\"usuarios_h.jsp\">Administracion</a>");
                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>







