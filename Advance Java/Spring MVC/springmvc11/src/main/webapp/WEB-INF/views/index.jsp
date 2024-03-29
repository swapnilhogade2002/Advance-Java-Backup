<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ page isErrorPage="true"%>
<%@include file="base.jsp"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Cache-Control" content="no-store, no-cache, must-revalidate">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">
<title>Index Page</title>
</head>
<script>
	function confirmDelete(productId) {
		var confirmDelete = confirm("Are you sure you want to delete this product?");
		if (confirmDelete) {
			window.location.href = "delete/" + productId;
		}
	}

</script>
<body>
	<!-- header -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark" >
		<a class="navbar-brand" href="#"><b>Product Management System
		</b></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>

				</li>
			</ul>

			<li class="nav-item  ml-auto"><a href="loginpage"
				class="btn btn-warning">Logout</a></li>
		</div>
	</nav>

	<!-- CRUD operation -->
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">

				<div container mt-3>
					<a href="add-product" class="btn btn-success ">Add Product</a>
				</div>

				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Product Name</th>
							<th scope="col">Product Description</th>
							<th scope="col">Product Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products}" var="p">
							<tr>
								<th scope="row">${p.id}</th>
								<td>${p.name }</td>
								<td>${p.description }</td>
								<td>${p.price}</td>

								<td><a href="delete/${p.id}" class="text-danger"
									title="Delete"> <i class="fas fa-trash-alt" onclick="confirmDelete(${p.id}); return false;"></i>
								</a> <a href="update/${p.id}" class="text-primary" title="Update">
										<i class="fas fa-pencil-alt"></i>
								</a> <a href="view/${p.id}" class="text-info" title="View Details">
										<i class="fas fa-eye"></i>
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>

<script>
function confirmDelete(productId) {
	   var confirmDelete = confirm("Are you sure you want to delete this product?");
	   if (confirmDelete) {
	     document.getElementById('deleteForm' + productId).submit();
	   }
	 }
</script>

<!-- footer -->
<!-- style="position: fixed; bottom: 0; width: 100%;" -->
<footer class="bg-dark text-white text-center"
	class="bg-body-tertiary text-center "
	class="bg-body-tertiary text-center">
	<!-- Grid container -->
	<div class="container p-4 pb-0 ">
		<!-- Section: Social media -->
		<section class="mb-4">
			<!-- Facebook -->
			<a data-mdb-ripple-init class="btn text-white btn-floating m-1"
				style="background-color: #3b5998;" href="#!" role="button"><i
				class="fab fa-facebook-f"></i></a>

			<!-- Twitter -->
			<a data-mdb-ripple-init class="btn text-white btn-floating m-1"
				style="background-color: #55acee;" href="#!" role="button"><i
				class="fab fa-twitter"></i></a>

			<!-- Google -->
			<a data-mdb-ripple-init class="btn text-white btn-floating m-1"
				style="background-color: #dd4b39;" href="#!" role="button"><i
				class="fab fa-google"></i></a>

			<!-- Instagram -->
			<a data-mdb-ripple-init class="btn text-white btn-floating m-1"
				style="background-color: #ac2bac;" href="#!" role="button"><i
				class="fab fa-instagram"></i></a>

			<!-- Linkedin -->
			<a data-mdb-ripple-init class="btn text-white btn-floating m-1"
				style="background-color: #0082ca;" href="#!" role="button"><i
				class="fab fa-linkedin-in"></i></a>
			<!-- Github -->
			<a data-mdb-ripple-init class="btn text-white btn-floating m-1"
				style="background-color: #333333;" href="#!" role="button"><i
				class="fab fa-github"></i></a>
		</section>
		<!-- Section: Social media -->
	</div>
	<!-- Grid container -->

	<!-- Copyright -->
	<div class="text-center p-3"
		style="background-color: rgba(0, 0, 0, 0.05);">
		© 2023 Copyright: <a class="text-body" href="">Aress.com</a>
	</div>
	<!-- Copyright -->
</footer>
</html>