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
                <h3>Bienvenido <%= user %> </h3>
                <p>rol <%= rol %> </p>
                <p>Hospital # <%= hospitalNum %></p>
                <a class="button" href="pacientes_h.jsp">Ver pacientes</a>
                <a class="button" href="citas_h.jsp">Ver Citas</a>
                <a class="button" href="confirmarSeguro.jsp">comprobar seguro</a>
            </div>
        </div>
    </div>
</body>
</html>
