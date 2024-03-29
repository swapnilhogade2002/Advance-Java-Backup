<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="welcome.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	rel="stylesheet"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body style="background-color: black">
	<!-- data are not stored -->
	<%
	response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");
	if (session.getAttribute("email") == null) {
		response.sendRedirect("login.jsp");
	}
	%>

	<!--header  -->
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <ul class="nav navbar-nav">
            <li class="active"><a href="#"><b>Aress Software & Education Technologies</b></a></li>
        </ul>
        <ul class="nav navbar-nav ml-auto">
            <li>
                <form action="Logout">
                    <button class="btn btn-danger navbar-btn">Logout</button>
                </form>
            </li>
        </ul>
    </div>
</nav>


	<%-- <h1>Welcome ${uname}</h1> --%>
	<!--welcome image  -->
	<center>
		<h2 class="animated fadeIn delay-1s h2">
			<b> Welcome to Aress Software & Education Technologies</b>
		</h2>
	</center>

	<center>
		<h5>
			<b>Employee Database</b>
		</h5>
		<div class="container">
			<!-- First Row -->
			<div class="row">
				<div class="col-md-4">
					<img
						src="https://images.pexels.com/photos/374598/pexels-photo-374598.jpeg?auto=compress&cs=tinysrgb&w=600"
						class="img-responsive img-thumbnail img-zoom">
				</div>
				<div class="col-md-4">
					<img
						src="https://images.pexels.com/photos/2041627/pexels-photo-2041627.jpeg?auto=compress&cs=tinysrgb&w=600"
						class="img-responsive img-thumbnail img-zoom">
				</div>
				<div class="col-md-4">
					<img
						src="https://images.pexels.com/photos/3183197/pexels-photo-3183197.jpeg?auto=compress&cs=tinysrgb&w=600"
						class="img-responsive img-thumbnail img-zoom">
				</div>
			</div>

			<!-- Second Row -->
			<div class="row">
				<div class="col-md-4">
					<img
						src="https://images.pexels.com/photos/323705/pexels-photo-323705.jpeg?auto=compress&cs=tinysrgb&w=600"
						class="img-responsive img-thumbnail img-zoom">
				</div>
				<div class="col-md-4">
					<img
						src="https://images.pexels.com/photos/9998331/pexels-photo-9998331.jpeg?auto=compress&cs=tinysrgb&w=600"
						class="img-responsive img-thumbnail img-zoom">
				</div>
				<div class="col-md-4">
					<img
						src="https://images.pexels.com/photos/3184639/pexels-photo-3184639.jpeg?auto=compress&cs=tinysrgb&w=600"
						class="img-responsive img-thumbnail img-zoom">
				</div>
			</div>
		</div>
	</center>


	<!-- display data on JSP with error handling -->
	<center>
		<table border="2" style="width:80%">
			<tr>
				<th>Sr.</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Age</th>
				<th>Gender</th>
				<th>Address</th>
				<th>City</th>
				<th>State</th>
				<th>Postal Code</th>
				<th>Phone Number</th>
			</tr>
			<%
			Connection conn = null;
			Statement st = null;
			ResultSet rs = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shree", "root", "mysql@2002");
				st = conn.createStatement();
				String query = "select* from homeData";
				rs = st.executeQuery(query);
				while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getString(1)%></td>
				<td><%=rs.getString(2)%></td>
				<td><%=rs.getString(3)%></td>
				<td><%=rs.getString(4)%></td>
				<td><%=rs.getString(5)%></td>
				<td><%=rs.getString(6)%></td>
				<td><%=rs.getString(7)%></td>
				<td><%=rs.getString(8)%></td>
				<td><%=rs.getString(9)%></td>
				<td><%=rs.getString(10)%></td>
				<td><%=rs.getString(11)%></td>
			</tr>
			<%
			}
			} catch (Exception e) {
			}
			%>
		</table>
	</center>

	<!-- footer -->
	<div class="footer">
		<b>All Copyright Reserved</b> <i class="fas fa-copyright"></i>
	</div>
</html>