<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align: center">

		<a href="loginForm">Login</a>
	</div>
	<form action="search">
		<input type="text" name="choice">
		 <input type="submit" value="search">
	</form>
	<br>
	
	<h1>${msg}</h1>
	<br><h1>${bookmsg}</h1><br>
	<br>

		<c:if test="${bookList ne null }">
			<table>
				<tr>
					<th>Title</th>
					<th>Author</th>
					<th>Category</th>
					<th>Price</th>
					<th></th>
				</tr>
				<c:forEach var="book" items="${bookList}">
					<tr>
						<td>${book.title}</td>
						<td>${book.author}</td>
						<td>${book.category}</td>
						<td>${book.price}</td>
						<td><input type="button" value="View"></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

</body>
</html>