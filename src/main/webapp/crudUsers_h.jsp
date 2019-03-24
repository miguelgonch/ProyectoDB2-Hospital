<%-- 
    Document   : manejoUsuarios
    Created on : Mar 11, 2019, 11:17:32 AM
    Author     : manu
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
     <!--head-->
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="CRUD Usuarios" />
    </jsp:include>
    <!--navbar logged-->
    <%@ include file="partials/_headerLogged.jsp"%>
    <!--Verify if the user has access-->
    <%@ include file="partials/_getInfo.jsp"%>
    <%
        if(rol.equals("1")||rol.equals("1")){
        }
        else{
            response.sendRedirect("home_h.jsp");
        }
    %>
    <body>
       <div class="grid-container">
                <div class="grid-x align-center-middle login">
                    <div class="cell small-10 medium-5">
                        <form class="form" action='crudUser_h' method='post'>
                           <input type="hidden" name="hospNum" value="3" >
                           <!-- <input type="radio" name="hospitalNum" value="1" checked>Hospital1 
                            <input type="radio" name="hospitalNum" value="2">Hospital2 
                            <input type="radio" name="hospitalNum" value="3">Hospital3<br>
                           -->
                            <label class=''>Usuario a editar
                                <input type="text" placeholder="Usuario" name='user' required>
                            </label>
                            
                            <p><input type="submit" class="button expanded" value="Buscar"></p>
                            
                        </form>
                        
                        <a class="button expanded" href="addUser_h.jsp">Agregar usuario</a>
                    </div>
                </div>
        </div>
        
                           <h1>Cookies</h1>
                           <% 
                               Cookie ck[] = request.getCookies();
                               for(int i=0;i<ck.length;i++)
                               {
                               out.println("Cookie name: "+ck[i].getName()+" y valor: "+ck[i].getValue()+"</br>");
                               }
                           %>
        <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Telefono</th>
                                <th>DPI</th>
                                <th>Numero de seguro</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        <tbody id="patientData">
                        </tbody>
                    </table>
        
    </body>
     
    <script src="js/vendor/what-input.js"></script>
    <script src="js/vendor/foundation.js"></script>
    <script src="js/app.js"></script>
    
</html>














































