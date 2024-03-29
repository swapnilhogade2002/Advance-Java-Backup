<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Cache-Control"
	content="no-store, no-cache, must-revalidate">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/sweetalert2@10">
<style>
.error {
	color: red;
}
</style>
<script>
        function validateForm() {
            var firstName = document.getElementById('firstName').value;
            var lastName = document.getElementById('lastName').value;
            var city = document.getElementById('city').value;
            var email = document.getElementById('exampleInputEmail1').value;
            var userName = document.getElementById('username').value;
            var password = document.getElementById('password').value;

            var firstNameError = document.getElementById('firstNameError');
            var lastNameError = document.getElementById('lastNameError');
            var cityError = document.getElementById('cityError');
            var emailError = document.getElementById('emailError');
            var userNameError = document.getElementById('userNameError');
            var passwordError = document.getElementById('passwordError');

            var isValid = true;

            // First Name validation
            if (firstName.trim() === '') {
                firstNameError.innerHTML = 'First Name is required';
                isValid = false;
            } else if (firstName.length < 3 || firstName.length > 20) {
                firstNameError.innerHTML = 'First Name must be between 3 and 20 characters';
                isValid = false;
            } else {
                firstNameError.innerHTML = '';
            }

            // Last Name validation
            if (lastName.trim() === '') {
                lastNameError.innerHTML = 'Last Name is required';
                isValid = false;
            } else if (lastName.length < 3 || lastName.length > 20) {
                lastNameError.innerHTML = 'Last Name must be between 3 and 20 characters';
                isValid = false;
            } else {
                lastNameError.innerHTML = '';
            }

            // City validation
            if (city.trim() === '') {
                cityError.innerHTML = 'City is required';
                isValid = false;
            } else if (city.length < 3 || city.length > 20) {
                cityError.innerHTML = 'City must be between 3 and 20 characters';
                isValid = false;
            } else {
                cityError.innerHTML = '';
            }

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
            } else if (userName.length < 3 || userName.length > 20) {
                userNameError.innerHTML = 'Username must be between 3 and 20 characters';
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
                if (password.length < 8 || password.length > 20) {
                    passwordError.innerHTML = 'Password must be between 8 and 20 characters long';
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

            if (isValid) {
                showSuccessMessage();
            }

         // Prevent the default form submission
            return false;;
        }

        function showSuccessMessage() {
            Swal.fire({
                icon: 'success',
                title: 'Registration Successful!',
                text: 'Thank you for registering.',
                confirmButtonText: 'OK'
            }).then((result) => {
                // Check if the user clicked "OK"
                if (result.isConfirmed) {
                    // Redirect to the login page
                    window.location.href = 'loginpage';
                }
            });
        }
    </script>
</head>
<body>



	<div class="container mt-5">
		<div class="container text-center">
			<h4>Registration Form</h4>
		</div>

		<form action="processform" method="post"
			onsubmit="return validateForm()">
			<div class="form-group">
				<label for="exampleInputEmail1">Enter First Name</label> <input
					type="text" class="form-control" id="firstName"
					aria-describedby="emailHelp" placeholder="First Name"
					name="firstName">
				<div class="error" id="firstNameError"></div>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Enter Last Name</label> <input
					type="text" class="form-control" id="lastName"
					aria-describedby="emailHelp" placeholder="Last Name"
					name="lastName">
				<div class="error" id="lastNameError"></div>
			</div>
			<div class="form-group">
				<label for="city">Select City</label> <select class="form-control"
					id="city" name="city">
					<option value="">Select City</option>
					<option value="Nashik">Nashik</option>
					<option value="Mumbai">Mumbai</option>
					<option value="Pune">Pune</option>
				</select>
				<div class="error" id="cityError"></div>
			</div>


			<div class="form-group">
				<label for="exampleInputEmail1">Email address</label> <input
					type="email" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter email" name="email">
				<div class="error" id="emailError"></div>
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

	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
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
