<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register form</title>
</head>
<body>
<center>
<h1> Register Form</h1> 
<form action="RegisterServlet" method = "post">

Username: <input type="text" name="username"><br>
Password: <input type="password" name="password"><br>
Email: <input type="email" name="email">
<input type ="submit" value="Submit"><br>

</form>
</center>

</body>
</html>