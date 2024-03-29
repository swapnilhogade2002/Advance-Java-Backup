<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%-- <%@page isElIgnore="false"%> --%>

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

<style>
.error {
	color: red;
}
</style>

<script>
	function validateForm() {
		var email = document.getElementById('exampleInputEmail1').value;
		var userName = document.getElementById('username').value;
		var password = document.getElementById('password').value;

		var emailError = document.getElementById('emailError');
		var userNameError = document.getElementById('userNameError');
		var passwordError = document.getElementById('passwordError');

		var isValid = true;

		// Email validation
		if (email.trim() === '') {
			emailError.innerHTML = 'Email is required';
			isValid = false;
		} else {
			var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
			if (!emailRegex.test(email)) {
				emailError.innerHTML = 'Enter a valid email address';
				isValid = false;
			} else {
				emailError.innerHTML = '';
			}
		}

		// User Name validation
		if (userName.trim() === '') {
			userNameError.innerHTML = 'User Name is required';
			isValid = false;
		} else {
			var usernameRegex = /^[a-zA-Z0-9_]+$/;
			if (!usernameRegex.test(userName)) {
				userNameError.innerHTML = 'Username can only contain letters, numbers, and underscores';
				isValid = false;
			} else {
				userNameError.innerHTML = '';
			}
		}

		// Password validation
		if (password.trim() === '') {
			passwordError.innerHTML = 'Password is required';
			isValid = false;
		} else {
			// Check for minimum length
			if (password.length < 8) {
				passwordError.innerHTML = 'Password must be at least 8 characters long';
				isValid = false;
			} else {
				// Check for at least one uppercase letter, one lowercase letter, one number, and one special character
				var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]+$/;
				if (!passwordRegex.test(password)) {
					passwordError.innerHTML = 'Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character';
					isValid = false;
				} else {
					passwordError.innerHTML = '';
				}
			}
		}

		return isValid;
	}
</script>

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
			<h4>Registration Form</h4>
		</div>

		<form action="processform" method="post"
			onsubmit="return validateForm()">
			<div class="form-group">
				<label for="exampleInputEmail1">Email address</label> <input
					type="email" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter email" name="email">
				<div class="error" id="emailError"></div>
			</div>

			<div class="form-group">
				<label for="userName">User Name</label> <input type="username"
					class="form-control" id="username" aria-describedby="emailHelp"
					placeholder="Enter username" name="userName">
				<div class="error" id="userNameError"></div>
			</div>

			<div class="form-group">
				<label for="userPassword">Password</label> <input type="password"
					class="form-control" id="password" aria-describedby="emailHelp"
					placeholder="Enter password" name="password">
				<div class="error" id="passwordError"></div>
			</div>

			<div class="container text-center">
				<button type="submit" class="btn btn-success">Register</button>
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
