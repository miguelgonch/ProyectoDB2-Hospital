<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
    <h1>Welcome</h1>
    <form action="Validate" method="post">
        <input type="radio" name="hospitalNum" value="1">Hospital1 
        <input type="radio" name="hospitalNum" value="2">Hospital2 
        <input type="radio" name="hospitalNum" value="3">Hospital3<br>
        <input type="text" name="user_id" placeholder="User ID"/><br>
        <input type="password" name="password" placeholder="Password"/><br>
        <input type="submit" value="Login"/>
    </form>
</body>
</html>