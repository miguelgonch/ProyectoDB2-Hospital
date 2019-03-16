<%-- 
    Document   : manejoUsuarios
    Created on : Mar 11, 2019, 11:17:32 AM
    Author     : manu
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <!-- head -->
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="CRUD usuarios" />
    </jsp:include>
    <body>
       <div class="grid-container">
                <div class="grid-x align-center-middle login">
                    <div class="cell small-10 medium-5">
                        <form class="form" action='crudUser' method='post'>
                            <input type="radio" name="hospitalNum" value="1" checked>Hospital1 
                            <input type="radio" name="hospitalNum" value="2">Hospital2 
                            <input type="radio" name="hospitalNum" value="3">Hospital3<br>
                            <label class=''>Usuario a editar
                                <input type="text" placeholder="Usuario" name='user_id' required>
                            </label>
                            
                            <p><input type="submit" class="button expanded" value="Buscar"></p>
                            
                        </form>
                    </div>
                </div>
        </div>
        
    </body>
     
    <script src="js/vendor/what-input.js"></script>
    <script src="js/vendor/foundation.js"></script>
    <script src="js/app.js"></script>
    
</html>
















