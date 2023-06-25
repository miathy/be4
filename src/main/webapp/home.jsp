

<%@page import="coding.mentor.entity.Category"%>
<%@page import ="coding.mentor.service.CategoryService"%>
<%@ page import ="java.util.Date" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	Time: <%= new Date() %>
	<ul>
		<%
		
		String[] array={"coffe", "tea", "milk"};
		for (String s: array){
			out.println("<li>" + s+ "</li>");
			 
		}
		%>
	</ul>   

	<hr>
	<nav class="category-menu">
		<ul> 
			<%
			
			CategoryService categoryService  = new CategoryService();
			
			for (Category category: categoryService.getAllCategories()){
				out.println("<a href='book-list.jsp'><li>" 
					+ category.getName()+ "</li></a>");
				
			}
			%>
		</ul>
	</nav>
	<hr>
	<form action="book-list.jsp">
		<input type="text" name="bookName">
		<input type="submit" value="Search">
	</form>


</body>
</html>