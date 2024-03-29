<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>help</title>
</head>
<body>
	<h1>help page</h1>
	<%
	String name = (String) request.getAttribute("name");
	%>

	<!--this are dynamic value  -->
	<%-- <h2>Help name <%= name %></h2> --%>

	<!-- using spEl  -->
	<h1>Help ${name}</h1>
	
<%-- 	<c:forEach></c:forEach> --%>
</body>
</html>