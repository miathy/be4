<%@page import="coding.mentor.entity.Category"%>
<%@page import="coding.mentor.service.CategoryService"%>
<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	box-sizing: border-box;
}
.sub-body {
	float: left;
	width: 20%;
	padding: 10px;
	height: 300px; /* Should be removed. Only for demonstration */
}
.body:after {
	content: "";
	display: table;
	clear: both;
}
</style>
</head>
<body>
	<div class="header">
		<form action= home>
			<input type="text" name="bookName" value= {bookName} placeholder = "Enter Book Name"> <input type="submit"
				value="Search">
				<ul>	
			</ul>				
		</form>
		</div>
	
	<div class="container">
       
        <a href="register.jsp">
            <button class="btn btn-primary btn-lg">Register</button>
        </a>
    </div>
    <br>

	<div class="container">
       
        <a href="login.jsp">
            <button class="btn btn-primary btn-lg">Log In</button>
        </a>
    </div>
	
	<hr>
	<div class="body">
		<div class="sub-body">

			<ul>
				<%-- <%
			
			CategoryService categoryService  = new CategoryService();
			
			for (Category category: categoryService.getAllCategories()){
				out.println("<a href='book-list.jsp?categoryId=" + 
			category.getId() + " '><li>" + category.getName()+ "</li></a>");
				
			}
			%>--%>
				<%-- jsp generates html and respond html to browser --%>

				<c:forEach var="category" items="${categoryList}">
					<a href="home?categoryId=${category.id}">
						<li>${category.name}</li>
					</a>
				</c:forEach>
			</ul>
		</div>
		
		<div class="sub-body">
		<c:if test="${empty bookList and empty bookNameList }">
			No Book Available
		</c:if>
		 
		
		
		<c:if test="${not empty bookList}">
			<ul>
				<c:forEach var="book" items="${bookList}">
					<a  href="book?bookId=${book.id}">
						<li>${book.name}</li>					
					</a>
				</c:forEach>
			</ul>
			</c:if>
			
			<c:if test="${not empty bookNameList}">
			<ul>
				<c:forEach var="book" items="${bookNameList}">
					<a  href="book?bookId=${book.id}">
						<li>${book.name}</li>					
					</a>
				</c:forEach>
			</ul>
			</c:if>
			
		</div>
		
	</div>

	<hr>
	<div class="footer">this is coding mentor</div>
</body>
</html>