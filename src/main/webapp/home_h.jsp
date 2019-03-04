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
<h1>Login exitoso!!</h1>
<h3>Bienvenido <%= user %> </h3>
<p>rol <%= rol %> </p>
<p>Hospital # <%= hospitalNum %></p>
<a href="historial_h.jsp">Acceder al historial</a>
</body>
</html>