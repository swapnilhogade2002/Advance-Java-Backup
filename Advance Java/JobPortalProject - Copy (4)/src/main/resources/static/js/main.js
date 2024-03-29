(function($) {
	"use strict";

	// Spinner
	var spinner = function() {
		setTimeout(function() {
			if ($('#spinner').length > 0) {
				$('#spinner').removeClass('show');
			}
		}, 1);
	};
	spinner();


	// Initiate the wowjs
	new WOW().init();


	// Sticky Navbar
	$(window).scroll(function() {
		if ($(this).scrollTop() > 300) {
			$('.sticky-top').css('top', '0px');
		} else {
			$('.sticky-top').css('top', '-100px');
		}
	});


	// Back to top button
	$(window).scroll(function() {
		if ($(this).scrollTop() > 300) {
			$('.back-to-top').fadeIn('slow');
		} else {
			$('.back-to-top').fadeOut('slow');
		}
	});
	$('.back-to-top').click(function() {
		$('html, body').animate({ scrollTop: 0 }, 1500, 'easeInOutExpo');
		return false;
	});


	// Header carousel
	$(".header-carousel").owlCarousel({
		autoplay: true,
		smartSpeed: 1500,
		items: 1,
		dots: true,
		loop: true,
		nav: true,
		navText: [
			'<i class="bi bi-chevron-left"></i>',
			'<i class="bi bi-chevron-right"></i>'
		]
	});


	// Testimonials carousel
	$(".testimonial-carousel").owlCarousel({
		autoplay: true,
		smartSpeed: 1000,
		center: true,
		margin: 24,
		dots: true,
		loop: true,
		nav: false,
		responsive: {
			0: {
				items: 1
			},
			768: {
				items: 2
			},
			992: {
				items: 3
			}
		}
	});

})(jQuery);


/*validation js*/

function validateForm() {
			console.log("Validation working");

			var isValid = true;
			var cname = document.getElementById("companyName").value.trim();
			var location = document.getElementById("jobLocation").value.trim();
			var experience = document.getElementById("jobExperience").value.trim();
			var ctc = document.getElementById("jobCtc").value.trim();
			var detail = document.getElementById("jobDetails").value.trim();

			// Reset error messages
			document.getElementById("companyNameError").innerHTML = "";
			document.getElementById("jobLocationError").innerHTML = "";
			document.getElementById("jobExperienceError").innerHTML = "";
			document.getElementById("jobCtcError").innerHTML = "";
			document.getElementById("jobDetailsError").innerHTML = "";

			// Company Name
			if (cname === "") {
				document.getElementById("companyNameError").innerHTML = "Company name is required";
				isValid = false;
			} else if (cname.length > 50) {
				document.getElementById("companyNameError").innerHTML = "Company name must be at most 50 characters long";
				isValid = false;
			}

			// Job Location
			if (location === "") {
				document.getElementById("jobLocationError").innerHTML = "Job location is required";
				isValid = false;
			} else if (location.length > 50) {
				document.getElementById("jobLocationError").innerHTML = "Job location must be at most 50 characters long";
				isValid = false;
			}

			// Experience Required
			if (experience === "") {
				document.getElementById("jobExperienceError").innerHTML = "Experience required is required";
				isValid = false;
			} else if (isNaN(experience)) {
				document.getElementById("jobExperienceError").innerHTML = "Experience must be a number";
				isValid = false;
			} else if (experience < 0 || experience > 30) {
				document.getElementById("jobExperienceError").innerHTML = "Experience must be between 0 and 30 years";
				isValid = false;
			}

			// Annual CTC
			if (ctc === "") {
				document.getElementById("jobCtcError").innerHTML = "Annual CTC is required";
				isValid = false;
			} else if (isNaN(ctc)) {
				document.getElementById("jobCtcError").innerHTML = "CTC must be a number";
				isValid = false;
			} else if (ctc < 200000 || ctc > 10000000) { // 1 crore is 10,000,000
				document.getElementById("jobCtcError").innerHTML = "CTC must be between 2 lakh to 1 crore";
				isValid = false;
			}

			// Job Details
			if (detail === "") {
				document.getElementById("jobDetailsError").innerHTML = "Job details are required";
				isValid = false;
			} else if (detail.length > 300) {
				document.getElementById("jobDetailsError").innerHTML = "Job details must be at most 300 characters long";
				isValid = false;
			}

			// If all validations pass, return true to allow form submission
			return isValid;
		}





