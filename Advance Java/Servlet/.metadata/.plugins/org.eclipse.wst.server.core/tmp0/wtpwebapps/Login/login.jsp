<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="login.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> 
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script> 
  <script>
        // Check if an error message exists in the session and display it as an alert
        <% HttpSession m = request.getSession(); %>           
  </script>
</head>
<body>
	<section class="vh-100 out">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-6 text-black">

					<div class="px-5 ms-xl-4">
						<i class="fas fa-crow fa-2x me-3 pt-5 mt-xl-4"
							style="color: #709085;"></i> <span class="h1 fw-bold mb-0">Welcome to Aress Software & Education Technologies</span>
					</div>

					<div
						class=" loginPage d-flex align-items-center h-custom-2 px-5 ms-xl-4  pt-2 pt-xl-0 mt-xl-n5">

						<form style="width: 23rem;" action="Login" method="post">

							<h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Login</h3>
							<div class="form-outline mb-4">
								<input name="email" type="text"
									class="form-control form-control-lg" /> <label
									class="form-label" for="form2Example18">Email address</label>
							</div>

							<div class="form-outline mb-4">
								<input name="pass" type="password"
									class="form-control form-control-lg" /> <label
									class="form-label" for="form2Example28">Password</label>
							</div>

							<div class="pt-1 mb-4">
								<button class="btn btn-info btn-lg btn-block" type="submit">Login</button>
							</div>
							<p>
								Don't have an account? <a href="register.jsp" class="link-info ">	<button type="button" class="btn btn-success">Register Here!!!</button></a>								
							</p>
						</form>
					</div>

				</div>
				<div class="col-sm-6 px-0 d-none d-sm-block">
					<img
						src="https://images.pexels.com/photos/3822775/pexels-photo-3822775.jpeg?auto=compress&cs=tinysrgb&w=600"
						alt="Login image" class="w-100 vh-100"
						style="object-fit: cover; object-position: left;">
				</div>
			</div>
		</div>
	</section>
</body>


</html>