<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UpdateBook</title>
</head>
<body>
<h1>Update Book By Price</h1>
<form action="updateBook">
BookId<input type="text" name="bookid" value="${book.bookid}" readonly="readonly"><br>
Title <input type="text" name="title" value="${book.title}" readonly="readonly"><br>
Price <input type="text" name="price" value="${book.price}" ><br>
Author <input type="text" name="author" value="${book.author}" readonly="readonly"><br>
Category <input type="text" name="category" value= "${book.category }" readonly="readonly">
<input type="submit" value="updateBook">
</form>
</body>
</html>