<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>welcome to JSP</h1>

	<%
	out.println(5 + 8);
	%>
	
	<%!
	String coef="swapnil";
	%>
	
	<%
	out.println(coef);%>
</body>
</html>