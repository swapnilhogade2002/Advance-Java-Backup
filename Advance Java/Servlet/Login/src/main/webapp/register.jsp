<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="register.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <div class="container register">
        <div class="row">
            <div class="col-md-3 register-left" style="margin-top: 200px;">
                <h4><b>Registration form !!!</b></h4>
                <h5>Welcome</h5>
                <p>Welcome to Aress Software & Education Technologies</p>
            </div>
            <div class="col-md-9 register-right">
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <form action="Register" method="post" onsubmit="return validateForm()">
                            <div class="row register-form">
                                <div class="col-md-6">
                                    <!-- first name -->
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="fname" id="fname" placeholder="First Name *" pattern="[A-Za-z]+" oninput="removeSpaces(this)" autofocus />
                                        <span class="error" id="fname-error"></span>
                                    </div>

                                    <!-- last name -->
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="lname" id="lname" placeholder="Last Name *" oninput="removeSpaces(this)" />
                                        <span class="error" id="lname-error"></span>
                                    </div>

                                    <!-- password -->
                                    <div class="form-group">
                                        <input type="password" class="form-control" name="pass" id="pass" placeholder="Password *" oninput="removeSpaces(this)" />
                                        <span class="error" id="password-error"></span>
                                    </div>

                                    <!-- email -->
                                    <div class="form-group">
                                        <input type="email" class="form-control" name="email" id="email" placeholder="Your Email *" oninput="removeSpaces(this)" />
                                        <span class="error" id="email-error"></span>
                                    </div>

                                    <!-- phone -->
                                    <div class="form-group">
                                        <input type="number" class="form-control" name="phone" id="phone" placeholder="Your Phone *" oninput="removeSpaces(this)" />
                                        <span class="error" id="phone-error"></span>
                                    </div>

                                    <!-- submit button -->
                                    <input type="submit" class="btn btn-primary" value="submit" />
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- script tag -->
    <script>
        function removeSpaces(input) {
            input.value = input.value.replace(/\s/g, "");
        }

        function validateForm() {
            var valid = true;

            var firstName = document.getElementById("fname").value;
            var lastName = document.getElementById("lname").value;
            var password = document.getElementById("pass").value;
            var email = document.getElementById("email").value;
            var phone = document.getElementById("phone").value;

            var firstNameError = document.getElementById("fname-error");
            var lastNameError = document.getElementById("lname-error");
            var passwordError = document.getElementById("password-error");
            var emailError = document.getElementById("email-error");
            var phoneError = document.getElementById("phone-error");

            firstNameError.innerText = "";
            lastNameError.innerText = "";
            passwordError.innerText = "";
            emailError.innerText = "";
            phoneError.innerText = "";
      
            if (firstName.length < 3 || firstName.length > 25) {
                firstNameError.innerText = "First Name must be between 3 and 25 characters.";
                valid = false;
            } else if (/\d/.test(firstName)) {
                firstNameError.innerText = "First Name should not contain numbers.";
                valid = false;
            } else if (!/^[a-zA-Z]+$/.test(firstName)) {
                firstNameError.innerText = "First Name should only contain alphabetic characters.";
                valid = false;
            }
            
            if (lastName.length < 3 || lastName.length > 25) {
                lastNameError.innerText = "Last Name must be between 3 and 25 characters.";
                valid = false;
            }else if (/\d/.test(firstName)) {
                firstNameError.innerText = "Last Name should not contain numbers.";
                valid = false;
            }

            if (password.length < 4 || password.length > 25) {
                passwordError.innerText = "Password must be between 4 and 25 characters.";
                valid = false;
            } else if (!/(?=.*[A-Z])(?=.*[a-z])(?=.*\W)/.test(password)) {
                passwordError.innerText = "Password should contain at least one uppercase letter, one lowercase letter, and one special character.";
                valid = false;
            }

            if (!email.match(/[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}/)) {
                emailError.innerText = "Invalid email address format.";
                valid = false;
            }

            if (!phone.match(/^\d{10}$/)) {
                phoneError.innerText = "Phone number must be a 10-digit number without spaces or special characters.";
                valid = false;
            }

         /*    if (valid) {
                alert("Successfully registered...!");
            }
            
            else{
            	alert("You have addes duplcate value");
            }
         */
            return valid;
        }
     // Update the removeSpaces function to restrict entering numbers
        function removeSpaces(input) {
        	if (input.id === "fname" ) {
                input.value = input.value.replace(/\s/g, ""); // Remove spaces
                input.value = input.value.replace(/\d/g, ""); // Remove numbers
                input.value = input.value.replace(/[^a-zA-Z]/g, ""); // Remove numbers and special characters
               
            }
        	if (input.id === "lname" ) {
                input.value = input.value.replace(/\s/g, ""); // Remove spaces
                input.value = input.value.replace(/\d/g, ""); // Remove numbers
                input.value = input.value.replace(/[^a-zA-Z]/g, ""); // Remove numbers and special characters
            }
     
        }
    </script>
</body>
</html>
