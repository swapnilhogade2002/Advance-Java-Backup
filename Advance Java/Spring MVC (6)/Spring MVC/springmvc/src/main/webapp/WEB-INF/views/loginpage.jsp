<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">



<title>Login Page</title>
</head>
<body style="background-color: black">
	<!-- Section: Design Block -->
	<section class="background-radial-gradient overflow-hidden">
		<style>
.background-radial-gradient {
	background-color: hsl(218, 41%, 15%);
	background-image: radial-gradient(650px circle at 0% 0%, hsl(218, 41%, 35%)
		15%, hsl(218, 41%, 30%) 35%, hsl(218, 41%, 20%) 75%,
		hsl(218, 41%, 19%) 80%, transparent 100%),
		radial-gradient(1250px circle at 100% 100%, hsl(218, 41%, 45%) 15%,
		hsl(218, 41%, 30%) 35%, hsl(218, 41%, 20%) 75%, hsl(218, 41%, 19%) 80%,
		transparent 100%);
}

#radius-shape-1 {
	height: 220px;
	width: 220px;
	top: -60px;
	left: -130px;
	background: radial-gradient(#44006b, #ad1fff);
	overflow: hidden;
}

#radius-shape-2 {
	border-radius: 38% 62% 63% 37%/70% 33% 67% 30%;
	bottom: -60px;
	right: -110px;
	width: 300px;
	height: 300px;
	background: radial-gradient(#44006b, #ad1fff);
	overflow: hidden;
}

.bg-glass {
	background-color: hsla(0, 0%, 100%, 0.9) !important;
	backdrop-filter: saturate(200%) blur(25px);
}

</style>

		<div
			class="demo container px-4 py-5 px-md-5 text-center text-lg-start my-4 ">
			<div class="row gx-lg-5 align-items-center mb-5">
				<div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
					<h1 class="my-5 display-5 fw-bold ls-tight"
						style="color: hsl(218, 81%, 95%)">
						The best offer <br /> <span style="color: hsl(218, 81%, 75%)">for
							your business</span>
					</h1>
					<p class="mb-4 opacity-70" style="color: hsl(218, 81%, 85%)">
						Lorem ipsum dolor, sit amet consectetur adipisicing elit.
						Temporibus, expedita iusto veniam atque, magni tempora mollitia
						dolorum consequatur nulla, neque debitis eos reprehenderit quasi
						ab ipsum nisi dolorem modi. Quos?</p>
				</div>

				<div class="col-lg-6 mb-5 mb-lg-0 position-relative">
					<div id="radius-shape-1"
						class="position-absolute rounded-circle shadow-5-strong"></div>
					<div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

					<div class="card bg-glass">
						<div class="card-body px-4 py-5 px-md-5">
							<form action="userlogin" method="post">
								<!-- Email input -->
								<div class="form-outline mb-4">
									<input type="email" id="form3Example3" class="form-control"
										name="email" placeholder="Enter Valid Email Address"/> 
								</div>

								<!-- Password input -->
								<div class="form-outline mb-4">
									<input type="password" id="form3Example4" class="form-control"
										name="password" placeholder="Enter Valid Password" />
								</div>

								<!-- Submit button -->
								<button type="submit" class="btn btn-success btn-block mb-4">
									Login</button>

								<!-- Register button -->
								<a href="register" class="btn btn-primary btn-block mb-4">New User! Register
									Here.. </a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Section: Design Block -->

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
</html> --%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Login</title>
<style>
.gradient-custom-2 {
	/* fallback for old browsers */
	background: #fccb90;
	/* Chrome 10-25, Safari 5.1-6 */
	background: -webkit-linear-gradient(to right, #ee7724, #d8363a, #dd3675, #b44593);
	/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
	background: linear-gradient(to right, #ee7724, #d8363a, #dd3675, #b44593);
}

@media ( min-width : 768px) {
	.gradient-form {
		height: 100vh !important;
	}
}

@media ( min-width : 769px) {
	.gradient-custom-2 {
		border-top-right-radius: .3rem;
		border-bottom-right-radius: .3rem;
	}
}
</style>
</head>
<body>

	<section class="h-100 gradient-form" style="background-color: #eee;">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-xl-10">
					<div class="card rounded-3 text-black">
						<div class="row g-0">
							<div class="col-lg-6">
								<div class="card-body p-md-5 mx-md-4">

									<div class="text-center">
										<img
											src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/lotus.webp"
											style="width: 185px;" alt="logo">
										<h4 class="mt-1 mb-5 pb-1">We are The Lotus Team</h4>
									</div>

									<form action="userlogin" method="post">
										<p>Please login to your account</p>

										<div class="form-outline mb-4">
											<input type="email" id="form2Example11" class="form-control"
												placeholder="Phone number or email address" name="email" />
											<label class="form-label" for="form2Example11">Username</label>
										</div>

										<div class="form-outline mb-4">
											<input type="password" id="form2Example22"
												class="form-control" name="password" /> <label
												class="form-label" for="form2Example22">Password</label>
										</div>

										<div class="text-center pt-1 mb-5 pb-1">
											<button
												class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3"
												type="submit">Log in</button>

										</div>

										<div
											class="d-flex align-items-center justify-content-center pb-4">
											<p class="mb-0 me-2">Don't have an account?</p>
											<a href="register">
												<button type="button" class="btn btn-outline-danger">Create
													new</button>
											</a>

										</div>

									</form>

								</div>
							</div>
							<div class="col-lg-6 d-flex align-items-center gradient-custom-2">
								<div class="text-white px-3 py-4 p-md-5 mx-md-4">
									<h4 class="mb-4">We are more than just a company</h4>
									<p class="small mb-0">Lorem ipsum dolor sit amet,
										consectetur adipisicing elit, sed do eiusmod tempor incididunt
										ut labore et dolore magna aliqua. Ut enim ad minim veniam,
										quis nostrud exercitation ullamco laboris nisi ut aliquip ex
										ea commodo consequat.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

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