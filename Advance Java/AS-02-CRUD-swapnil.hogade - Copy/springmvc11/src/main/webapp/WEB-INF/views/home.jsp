<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
</head>
<body>
	<!-- sending data from controller to view -->
	<%
	String name = (String) request.getAttribute("name");
	%>
	<h1>
		welcome to home page
		<%=name%></h1>
</body>
</html>