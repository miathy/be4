<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1> Login Page</h1>

<form action="LoginServlet" method="get">
	Username:<input type="text" name="username"/>
	<br>
	Password:<input type="text" name="password"/>
	<br>	
	
	<input type="submit" value="Login"/>

</form>
</center>
</body>
</html>