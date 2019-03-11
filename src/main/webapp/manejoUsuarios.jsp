<%-- 
    Document   : manejoUsuarios
    Created on : Mar 11, 2019, 11:17:32 AM
    Author     : manu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administración ususarios</title>
    </head>
    <!--head-->
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Historial" />
    </jsp:include>
    <!--navbar logged-->
    <%@ include file="partials/_headerLogged.jsp"%>
    <!--Verify if the user has access-->
    <%@ include file="partials/_getInfo.jsp"%>
   
    <body>
      
        <form action="crudHospital.jsp" method=get>
	ingrese el id de ususario <input type="text" name="num2"><br>
	<input type="submit">
	</form>
        
        
    </body>
</html>
