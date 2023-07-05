<%@page import="coding.mentor.entity.Book"%>
<%@page import="coding.mentor.service.BookService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

	<%-- 	
	 if (request.getParameter("categoryId") != null){
				 
				 out.println("Request from category" ); 
				int categoryId = Integer.parseInt(request.getParameter("categoryId"));
				
				 BookService service = new BookService();  
				
				/* for (Book book: service.getBooksByCategoryId(categoryId)){
					out.println(" <li>" + book.getName()+ "</li>"); 
					
				} */ 
				pageContext.setAttribute("booklist",service.getBooksByCategoryId(categoryId));
			}	
			
			if (request.getParameter("bookName") != null){
				 
				out.println("Request from search");  
				String bookName = request.getParameter("bookName");	  
				
				 BookService service = new BookService();  
				
				/* for (Book book: service.getBooksByName(bookName)){
					out.println(" <li>" + book.getName()+ "</li>"); 				
			
				} */ 
				pageContext.setAttribute("booklist",service.getBooksByName(bookName));
			}	 
	
			 --%>	
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
</head>
<body>
Welcome to Booklist
	<hr>
		<ul>
			<c:forEach var="book" items="${bookList}" >
				<li>${book.name} - ${book.id }</li>
			
			</c:forEach>
	
	</ul>
</body>
</html>