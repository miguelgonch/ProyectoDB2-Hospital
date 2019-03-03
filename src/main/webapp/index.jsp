<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <jsp:include page="partials/_header.jsp">
        <jsp:param name="title" value="Portal de hospitales" />
    </jsp:include>
    <body>
        <div class="grid-container">
            <div class="grid-x align-center">
                <div class="cell small-10 medium-5">
                    <form class="log-in-form" action='Validate' method='post'>
                        <input type="radio" name="hospitalNum" value="1" checked>Hospital1 
                        <input type="radio" name="hospitalNum" value="2">Hospital2 
                        <input type="radio" name="hospitalNum" value="3">Hospital3<br>
                        <h4 class="text-center">Inicia sesión</h4>
                        <label class=''>Usuario
                            <input type="text" placeholder="Usuario" name='user_id' required>
                        </label>
                        <label class=''>Contaseña
                            <input type="password" placeholder="Contaseña" name='password' required>
                        </label>
                        <small class="advice " style="display: none">Por favor, verifica los datos ingresados</small> <input id="show-password" type="checkbox"><label for="show-password">Mostrar contraseña</label>
                        <p><input type="submit" class="button expanded" value="Login"></p>
                        <p class="text-center"><a href="#">¿Olvidaste tu constraseña?</a></p>
                    </form>
                    <p>Si todavía no tienes una cuenta haz click <a href="Register.html">aquí</a></p>
                </div>
            </div>
        </div>
    </body>
    <!-- footer-->
    <%@ include file="partials/_footer.jsp" %>
    
    <script src="js/vendor/what-input.js"></script>
    <script src="js/vendor/foundation.js"></script>
    <script src="js/app.js"></script>

</html>