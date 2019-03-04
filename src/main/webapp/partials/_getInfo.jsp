<%-- 
    Document   : _getInfo
    Created on : Mar 3, 2019, 10:29:59 PM
    Author     : migue
--%>

<%
    String hospitalNum = null,rol = null;
    Cookie[] cookiesInf = request.getCookies();
    if(cookiesInf !=null){
        for(Cookie cookie : cookiesInf){
            if(cookie.getName().equals("hospNum")){
                hospitalNum = cookie.getValue();
            }
            if(cookie.getName().equals("rol")){
                rol = cookie.getValue();
            }
        }
    }
    if(rol==null){
        rol = "not assigned yet";
    }
%>
