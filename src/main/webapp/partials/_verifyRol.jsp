<%-- 
    Document   : _verifyRol
    Created on : Mar 4, 2019, 9:43:41 AM
    Author     : migue
--%>
<!--get info cookies-->
<%@ include file="_getInfo.jsp"%>
<%
    int rol2 = Integer.parseInt(rol),rolReq = Integer.parseInt(request.getParameter("rol"));
    if(rol2!=rolReq){
        response.sendRedirect("index.jsp");   
    }
%>

