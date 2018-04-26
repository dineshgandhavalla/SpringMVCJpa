<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="text-align: right;">
<a href="/">Home</a>
</div>
<a href="showAddForm">Add Book</a>
<br>${result}<br>

<a href="showEditForm">Edit Book</a>
<br>${update}<br>
<a href="showDeleteForm">Delete Book</a>
${delete}<br>
	<br><h1>${bookmsg}</h1><br>
</body>
</html>