

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--head-->
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Modificar Usuario" />
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
            <div class="grid-x align-center-middle">
                <div class="cell small-10 medium-8">
                    <form class="form" action="restU/usuarios/addUsuarios" method="post">
                        <h4>Modificar Paciente</h4>
                         <label>username: 
                            <input id="usernombre" type="text" placeholder="Coloque el nuevo username del usuario" name="username" required>
                        </label>
                        <label>contrasenia 
                            <input id="contra" type="text" placeholder="Coloque el nuevo contrasenia del usuario" name="passw" required>
                        </label>
                        <label>Nombre:
                            <input type="number" value="<%=request.getParameter("uId")%>" style="display:none" name="uId">
                            <input id="nombreU" type="text" placeholder="Coloque el nuevo nombre del usuario" name="name" required>
                        </label>
                        <label>Apellido: 
                            <input id="apellidoU" type="text" placeholder="Coloque el nuevo apellido del usuario" name="lastName" required>
                        </label>
                       
                        <label>Telefono: 
                            <input id="tel" type="number" placeholder="Coloque el nuevo telefono del usuario" name="tel" required>
                        </label>
                         <!--   <label>Tipo Usuario 
                            <input id="usType" type="number" placeholder="Coloque el nuevo telefono del usuario" name="usType" required>
                        </label>
                            <label>Especialidad 
                            <input id="usSpecial" type="number" placeholder="Coloque el nuevo telefono del usuario" name="usSpecial" required>
                        </label>-->
                       
                        <br>
                        <label>Especialidad
                            <br>
                            <select id="usSpecial" name="usSpecial">
                                <optgroup label=categoria1><option value=1>onto</option><option value=2>pedia</option><optgroup label=categoria2><option value=4>neuro</option><option value=5>cardio</option><option value=6>general</option><option value=7>enfermera</option>            </select>
                        </label>
                            <br> 
                            <label>Tipo de usuario
                            <br>
                            <select id="usType" name="usType">
                                <option value=1>doctor</option><option value=2>practicante</option><option value=3>asistente</option></select>
                            </label>
                            
                        <input type="submit" class="cell button medium-8" value="Modificar">
                    </form>
                </div>
            </div>
        </div>
    </body>

    <script src="js/patientModInf.js"></script>
</html>
















































