<%@page import="coding.mentor.entity.Book"%>
<%@page import="coding.mentor.service.BookService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
</head>
<body>
Welcome to Booklist
	<hr>
		<ul>
			<%
			 if (request.getParameter("categoryId") != null){
				out.println("Request from category");  
				int categoryId = Integer.parseInt(request.getParameter("categoryId"));	  
				
				 BookService service = new BookService();  
				
				for (Book book: service.getBooksByCategoryId(1)){
					out.println(" <li>" + book.getName()+ "</li>"); 
					
			
				} 	 
			}	
	
			%> 
	
	
	</ul>
</body>
</html>