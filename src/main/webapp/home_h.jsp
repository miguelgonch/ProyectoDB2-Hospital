<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include page="partials/_head.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
<%@ include file="partials/_headerLogged.jsp"%>
<body>
<h1>Login exitoso!!</h1>
<h3>Bienvenido <%= user %></h3>
</body>
</html>