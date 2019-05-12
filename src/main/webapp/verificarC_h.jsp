<%-- 
    Document   : aggregarP_h
    Created on : Mar 12, 2019, 12:41:02 AM
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--head-->
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Confirmar Cita" />
    </jsp:include>
    <!--navbar logged-->
    <%@ include file="partials/_headerLogged.jsp"%>
    <!--Verify if the user has access-->
    <%@ include file="partials/_getInfo.jsp"%>
    <%
        if(rol.equals("1")||(rolNum<=4)){
        }
        else{
            response.sendRedirect("home_h.jsp");
        }
    %>
    <body>
        <div class="grid-container">
            <div class="grid-x align-center-middle">
                <div class="cell small-10 medium-8">
                    <form class="form" action="AddCita" method="post">
                        <h4>Confirmar Cita</h4>
                        <label>Paciente: 
                            <select id="patients" name="pId" required>
                            </select>
                        </label>
                        <label>Fecha: 
                            <input id="fecha" type="date" name="fechaCita" required>
                        </label>
                        <label>Doctor / Encargado: 
                            <select id="doctoresData" name="docId" required>
                            </select>
                        </label>
                        <label>Servicio: 
                            <select id="serviciosData" name="servicioId" required>
                            </select>
                        </label>
                        <label>Hora: 
                            <select id="horariosData" name="hora" required>
                            </select>
                        </label>
                        <div id="coberturaS">
                            <h4>Cobertura Seguro</h4>
                            <p id="tipoS">Tipo de seguro: </p>
                            <label>¿Utilizar Seguro? </label>
                        </div>
                            <select id="verifyAnsw" name="seg" required>
                            </select>
                        
                        <hr>
                    
                        <br>
                        <a class="cell button medium-8" data-open="addFounds">Pagar</a>
                        <input type="submit" class="cell button medium-8" value="Aceptar y Pagar">
                        <a href="home_h.jsp" class="button expanded">Cancelar</a>
                    </form>
                </div>
            </div>
        </div>
        <div class="reveal-overlay" style="display: none;">
            <div class="reveal" id="addFounds" data-reveal>
                <div class="grid-container">
                        <div class="small-12 cell">
                            <h4>Realizar pago:</h4>
                        </div>
                        <div class="small-12 cell">
                            <h5>Cantidad:</h5>
                        </div>
                        <div class="input-group small-12 cell">
                            <span class="input-group-label">Q</span>
                            <input class="input-group-field" type="int" name="monto" value="" placeholder="Ingrese el monto" required pattern="[0-9]+" required>
                        </div>
                        <div class="small-12 cell">
                            <h5>Información de la tarjeta:</h5>
                        </div>
                        <div class="input-group small-8 cell">
                            <span class="input-group-label">Titular:</span>
                            <input class="input-group-field" type="cvv" name='titular' pattern="[A-Za-z]+" placeholder="Nombre del titular de la tarjeta">
                        </div>
                        <div class="input-group small-4 cell">
                            <span class="input-group-label">cvv:</span>
                            <input class="input-group-field" type="cvv" name='cvv' pattern="[0-9]{3,4}" placeholder="### or ####">
                        </div>
                        <div class="input-group small-12 cell">
                            <span class="input-group-label">Tarjeta:</span>
                            <input class="input-group-field" type="card" name="tarjeta" placeholder="Ingrese el numero de la tarjeta" pattern="[0-9]+">
                        </div>
                        <div class="input-group small-12 cell">
                            <span class="input-group-label">Fecha de Vencimiento:</span>
                            <input class="input-group-field" type="month" name='fecha_vencimiento'>
                        </div>

                </div>
            </div>
        </div>
    </body>
    <script type="text/javascript" src="js/docInf.js"></script>
    <script type="text/javascript" src="js/horarioInf.js"></script>
    <script type="text/javascript" src="js/serviciosList.js"></script>
    <script type="text/javascript" src="js/patientsList.js"></script>
    <script type="text/javascript" src="js/verify/getData.js"></script>
    <script type="text/javascript" src="js/verify/getDataCobertura.js"></script>
    <script src="js/vendor/what-input.js"></script>
    <script src="js/vendor/foundation.js"></script>
    <script src="js/app.js"></script>
</html>
