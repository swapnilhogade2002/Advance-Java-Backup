/*<![CDATA[*/
$(document).ready(function() {
	$('.datepicker').datepicker({
		format: 'yyyy-mm-dd',
		autoclose: true
	});
});

function validateForm() {
	// Reset error messages
	document.getElementById('nameError').innerText = '';
	document.getElementById('emailError').innerText = '';
	document.getElementById('cityError').innerText = '';
	document.getElementById('salaryError').innerText = '';
	document.getElementById('genderError').innerText = '';
	document.getElementById('maritalStatusError').innerText = '';
	document.getElementById('educationLevelError').innerText = '';
	document.getElementById('joiningDateError').innerText = '';
	document.getElementById('usernameError').innerText = '';
	document.getElementById('passwordError').innerText = '';

	var isValid = true;

	// Name validation
	var nameInput = document.getElementById('name');
	var nameError = document.getElementById('nameError');
	if (!nameInput.value.trim()) {
		nameError.innerText = 'Name is required.';
		isValid = false;
	}

	// Email validation
	var emailInput = document.getElementById('email');
	var emailError = document.getElementById('emailError');
	if (!emailInput.value.trim()) {
		emailError.innerText = 'Email is required.';
		isValid = false;
	}

	// City validation
	var cityInput = document.getElementById('city');
	var cityError = document.getElementById('cityError');
	if (!cityInput.value.trim()) {
		cityError.innerText = 'City is required.';
		isValid = false;
	}

	// Salary validation
	var salaryInput = document.getElementById('salary');
	var salaryError = document.getElementById('salaryError');
	if (!salaryInput.value.trim()) {
		salaryError.innerText = 'Salary is required.';
		isValid = false;
	}

	return isValid;
}
        /*]]>*/