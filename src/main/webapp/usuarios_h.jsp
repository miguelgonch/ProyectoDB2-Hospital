<%-- 
    Document   : usuarios_h
    Created on : Mar 10, 2019, 8:36:30 PM
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--head-->
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Usuarios" />
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
        if((request.getParameter("in")!=null)){
            if(request.getParameter("in").equals("1")){
                out.println("<script>alert(\"Paciente agregado exitosamente!\");</script>");
            }
            else if(request.getParameter("in").equals("0")){
                out.println("<script>alert(\"No se ha logrado agregar el usuario, vuelve a intentarlo\");</script>");
            }
        }
        if((request.getParameter("up")!=null)){
            if(request.getParameter("up").equals("1")){
                out.println("<script>alert(\"Paciente actualizado exitosamente!\");</script>");
            }
            else if(request.getParameter("up").equals("0")){
                out.println("<script>alert(\"No se ha logrado actualizar el usuario, vuelve a intentarlo\");</script>");
            }
        }
        if((request.getParameter("del")!=null)){
            if(request.getParameter("del").equals("1")){
                out.println("<script>alert(\"Paciente eliminado exitosamente!\");</script>");
            }
            else if(request.getParameter("del").equals("0")){
                out.println("<script>alert(\"No se ha logrado eliminar el usuario, vuelve a intentarlo\");</script>");
            }
        }

    %>
    <body>
        <div class="grid-container">
            <div class="grid-x align-center">
                <div class="cell small-10 medium-12">
                    <h1>Usuarios</h1>
                    <a class="button" href="addUser_h.jsp">Agregar usuario</a>
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>username</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Tipo de usuario</th>
                                <th>Especialidad</th>
                                <th>telefono</th>
                            </tr>
                        </thead>
                        <tbody id="usuarioData">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
    <script src="js/usuarios.js"></script>
</html>
