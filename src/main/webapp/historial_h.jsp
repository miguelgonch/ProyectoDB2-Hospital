<%-- 
    Document   : historial_h
    Created on : Mar 4, 2019, 9:46:13 AM
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--head-->
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Historial" />
    </jsp:include>
    <!--check access through rol-->
    <jsp:include page="partials/_verifyRol.jsp">
        <jsp:param name="rol" value="1" />
    </jsp:include>
    <!--navbar logged-->
    <%@ include file="partials/_headerLogged.jsp"%>
    <body>
        <h1>Historiales</h1>
    </body>
</html>
