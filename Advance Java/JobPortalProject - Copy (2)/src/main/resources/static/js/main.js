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


/*search js*/

// JavaScript for handling job search form submission
document.addEventListener('DOMContentLoaded', function () {
    const jobSearchForm = document.getElementById('jobSearchForm');
	const searchResultsContainer = document.getElementById('searchResultsContainer');
    const jobPostings = []; // Add your job postings data here

    // Function to perform search and display results
    function searchJobPostings(query) {
        // Clear previous search results
        searchResultsContainer.innerHTML = '';

        // Filter job postings based on the search query
        const filteredJobPostings = jobPostings.filter(jobPosting =>
            jobPosting.profile.toLowerCase().includes(query.toLowerCase())
        );

        // Display search results
        filteredJobPostings.forEach(jobPosting => {
            const jobItem = document.createElement('div');
            jobItem.classList.add('job-item');
            jobItem.innerHTML = `
                <h5>${jobPosting.profile}</h5>
                <p>${jobPosting.location}</p>
                <!-- Add more job details here as needed -->
            `;
            searchResultsContainer.appendChild(jobItem);
        });

        // If no results found
        if (filteredJobPostings.length === 0) {
            const noResultsMessage = document.createElement('p');
            noResultsMessage.textContent = 'No job postings found.';
            searchResultsContainer.appendChild(noResultsMessage);
        }
    }

    // Event listener for form submission
    jobSearchForm.addEventListener('submit', function (event) {
        event.preventDefault();
        const searchQuery = this.querySelector('input[name="location"]').value.trim();
        searchJobPostings(searchQuery);
    });
});






