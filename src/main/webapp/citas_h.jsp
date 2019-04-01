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
        <jsp:param name="title" value="Citas" />
    </jsp:include>
    <!--navbar logged-->
    <%@ include file="partials/_headerLogged.jsp"%>
    <!--Verify if the user has access-->
    <%@ include file="partials/_getInfo.jsp"%>
    <%
        if(rol.equals("1")||(rolNum<=3)){
            
        }
        else{
            response.sendRedirect("home_h.jsp");
        }
        if((request.getParameter("in")!=null)){
            if(request.getParameter("in").equals("1")){
                out.println("<script>alert(\"Cita agregada exitosamente!\");</script>");
            }
            else if(request.getParameter("in").equals("0")){
                out.println("<script>alert(\"No se ha logrado agregar la cita, vuelve a intentarlo\");</script>");
            }
        }
        if((request.getParameter("up")!=null)){
            if(request.getParameter("up").equals("1")){
                out.println("<script>alert(\"Cita actualizada exitosamente!\");</script>");
            }
            else if(request.getParameter("up").equals("0")){
                out.println("<script>alert(\"No se ha logrado actualizar la cita, vuelve a intentarlo\");</script>");
            }
        }
        if((request.getParameter("del")!=null)){
            if(request.getParameter("del").equals("1")){
                out.println("<script>alert(\"Cita eliminada exitosamente!\");</script>");
            }
            else if(request.getParameter("del").equals("0")){
                out.println("<script>alert(\"No se ha logrado eliminar la cita, vuelve a intentarlo\");</script>");
            }
        }
    %>
    <body>
        
        <div class="grid-container">
            <div class="grid-x align-center">
                <div class="cell small-10 medium-12">
                    <h1>Citas:</h1>
                    <a class="button" href="aggregarC_h.jsp">Nueva Cita</a>
                    <table>
                        <thead>
                            <tr>
                                <th>ID Cita</th>
                                <th>Area</th>
                                <th>Doctor</th>
                                <th>Paciente</th>
                                <th>Fecha</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody id="historialData">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
    <script src="js/citas.js"></script>
</html>
