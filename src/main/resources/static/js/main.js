function myFunction() {
        	  var x = document.getElementById("myTopnav");
        	  if (x.className === "topnav") {
        	    x.className += " responsive";
        	  } else {
        	    x.className = "topnav";
        	  }
        	}
        
        var currentURL = window.location.href;

     // Get all navigation links
    var navLinks = document.querySelectorAll('.topnav a');

// Add click event listener to each navigation link
navLinks.forEach(function(link) {
    link.addEventListener('click', function() {
        // Remove 'active' class from all links
        navLinks.forEach(function(navLink) {
            navLink.classList.remove('active');
        });
        
        // Add 'active' class to the clicked link
        this.classList.add('active');
    });
});

document.addEventListener("DOMContentLoaded", function() {
    // Show the default tab content and set the first tab as active by default
    document.getElementById("London").style.display = "block";
    document.querySelector(".tablinks").classList.add("active");
});

function openCity(evt, cityName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active";
}