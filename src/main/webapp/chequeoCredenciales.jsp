  
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
String id = request.getParameter("usuario_id");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:8080/";
String dbName = "hospital3";
String userId = "c##hospital3";
String password = "manu";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>

<!DOCTYPE html>
<html>
    <!-- head -->
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Inicio de sesion" />
    </jsp:include>
    
    
<h2 align="center"><font><strong>Retrieve data from database in jsp</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">
<td><b>usuario_id</b></td>
<td><b>usuario</b></td>
<td><b>nombre</b></td>
<td><b>apellido</b></td>
<td><b>tipo_usuario_id</b></td>
<td><b>especialidad_id</b></td>
<td><b>telefono</b></td>
<td><b>pass</b></td>
</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM USUARIO";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="#DEB887">

<td><%=resultSet.getString("usuario_id") %></td>
<td><%=resultSet.getString("usuario") %></td>
<td><%=resultSet.getString("nombre") %></td>
<td><%=resultSet.getString("apellido") %></td>
<td><%=resultSet.getString("tipo_usuario_id") %></td>
<td><%=resultSet.getString("especialidad_id") %></td>
<td><%=resultSet.getString("telefono") %></td>
<td><%=resultSet.getString("pass") %></td>

</tr>

<% 
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>

<script src="js/vendor/what-input.js"></script>
    <script src="js/vendor/foundation.js"></script>
    <script src="js/app.js"></script>

</html>



