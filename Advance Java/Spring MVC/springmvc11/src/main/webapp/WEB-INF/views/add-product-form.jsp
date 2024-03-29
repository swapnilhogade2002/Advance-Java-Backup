<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<style>
.error {
	color: red;
}
</style>

<script>
	function validateForm() {
		var name = document.getElementById('exampleInputEmail1').value.trim();
		var description = document.getElementById('description').value.trim();
		var price = document.getElementById('price').value.trim();

		var nameError = document.getElementById('nameError');
		var descriptionError = document.getElementById('descriptionError');
		var priceError = document.getElementById('priceError');

		var isValid = true;

		// Name validation
		var maxNameLength = 50; // Set your desired maximum length for the name
		if (name === '') {
			nameError.innerHTML = 'Product Name is required';
			isValid = false;
		} else if (name.length > maxNameLength) {
			nameError.innerHTML = 'Product Name exceeds the maximum length of '
					+ maxNameLength + ' characters.';
			isValid = false;
		} else {
			nameError.innerHTML = '';
		}

		// Description validation
		var maxDescriptionLength = 200; // Set your desired maximum length for the description
		if (description === '') {
			descriptionError.innerHTML = 'Product Description is required';
			isValid = false;
		} else if (description.length > maxDescriptionLength) {
			descriptionError.innerHTML = 'Product Description exceeds the maximum length of '
					+ maxDescriptionLength + ' characters.';
			isValid = false;
		} else {
			descriptionError.innerHTML = '';
		}

		// Price validation
		if (price === '') {
			priceError.innerHTML = 'Product Price is required';
			isValid = false;
		} else if (isNaN(Number(price)) || Number(price) <= 0) {
			priceError.innerHTML = 'Enter a valid positive number for Price';
			isValid = false;
		} else {
			priceError.innerHTML = '';
		}

		return isValid;
	}
</script>

<title>Add Product</title>
</head>
<body>
	<div class="container mt-5">
		<div class="container text-center">
			<h4>Add Product</h4>
		</div>

		<form action="handle-product" method="post"
			onsubmit="return validateForm()">
			<div class="form-group">
				<label for="exampleInputEmail1">Enter Product Name</label> <input
					type="name" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter name" name="name"
				>
				<div class="error" id="nameError"></div>
			</div>

			<div class="form-group">
				<label for="description">Enter Product Description</label> <input
					type="description" class="form-control" id="description"
					aria-describedby="emailHelp"
					placeholder="Enter product description" name="description">
				<div class="error" id="descriptionError"></div>
			</div>

			<div class="form-group">
				<label for="price">Product Price</label> <input type="price"
					class="form-control" id="price" aria-describedby="emailHelp"
					placeholder="Enter Price" name="price">
				<div class="error" id="priceError"></div>
			</div>

			<div class="container text-center">
				<button type="submit" class="btn btn-success">Submit</button>
				<a href="index" class="btn btn-warning">Back</a>
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
