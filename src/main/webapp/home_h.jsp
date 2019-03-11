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
<h3>Bienvenido <%= user %> </h3>
<p>rol <%= rol %> </p>
<p>Hospital # <%= hospitalNum %></p>
<a href="pacientes_h.jsp">Ver pacientes</a>
</body>
</html>