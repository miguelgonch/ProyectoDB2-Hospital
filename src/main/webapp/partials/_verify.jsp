<%-- 
    Document   : _verifyAccess
    Created on : Mar 3, 2019, 1:03:04 PM
    Author     : migue
--%>
<%
    String user = null;
    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("user")){
                user = cookie.getValue();
            }
        }
    }
    if(user==null){
        response.sendRedirect("login_h.jsp");
    }
%>