<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Cache-Control"
	content="no-store, no-cache, must-revalidate">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Change Product</title>
</head>
<body>

	<%
	// Get all cookies from the request
	Cookie[] cookies = request.getCookies();

	if (cookies != null) {
		for (Cookie cookie : cookies) {
			// Assuming you want to delete a cookie named "myCookie"
			if ("myCookie".equals(cookie.getName())) {
		// Set the cookie's max age to 0 (zero) to delete it
		cookie.setMaxAge(0);
		// Add the cookie to the response to update the client
		response.addCookie(cookie);

		// Alternatively, you can remove the cookie from the response directly
		// response.addCookie(new Cookie("myCookie", null));
			}
		}
	}
	%>
	<div class="container mt-5">
		<div class="container text-center">
			<%-- <h6>${header}</h6> --%>
			<h4>Edit Product Details</h4>
		</div>

		<form action="${pageContext.request.contextPath }/handle-product"
			method="post">
			<input type="hidden" value="${product.id}" name="id" />
			<div class="form-group">
				<label for="productName">Enter Product Name</label> <input
					type="text" class="form-control" id="productName"
					aria-describedby="emailHelp" placeholder="Enter name" name="name"
					value="${product.name}">
			</div>

			<div class="form-group">
				<label for="productDescription">Enter Product Description</label> <input
					type="text" class="form-control" id="productDescription"
					aria-describedby="emailHelp"
					placeholder="Enter product description" name="description"
					value="${product.description}">
			</div>

			<div class="form-group">
				<label for="productPrice">Product Price</label> <input type="text"
					class="form-control" id="productPrice" aria-describedby="emailHelp"
					placeholder="Enter Price" name="price" value="${product.price}">
			</div>

			<div class="container text-center">
				<button type="submit" class="btn btn-success">Submit</button>
				<a href="${pageContext.request.contextPath }/index"
					class="btn btn-warning">Back
					</button>
				</a>
			</div>


		</form>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>