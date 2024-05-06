let title;
let url;
let lecturer;
let rating;
let reviews;
let completionRatio = "35%";


function sendEmail() {
    event.preventDefault();

    const endPoint = "/getDetails";

    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let number = document.getElementById("phone").value;
    let message = document.getElementById("message").value;

    let details = {
        name: name,
        email: email,
        number: number,
        message: message
    };

    const options = {
        method: 'POST',
        headers: {
        'Content-Type': 'application/json'
        },
        body: JSON.stringify(details)
    };

     $.ajax({
            type: "POST",
            url: endPoint,
            contentType: "application/json",
            data: JSON.stringify(details),
            success: function(data) {
                endEndPoint();
                successAlert();
            },
            error: function(xhr, status, error) {
                console.error("Problem with AJAX operation", error);
            }
        });
}

function endEndPoint(){
    $.ajax({
        type: "POST",
        url: "/sendMail",
        success: function(data) {
        },
        error: function(xhr, status, error) {
            console.error("Problem with AJAX operation", error);
        }
    });
}

function successAlert(){
    alert("Your message sent succesfully. \nI will answer you in 1 day. \nGood LUCK!!")
}

//On Click
function hoverOnCourse(){
document.addEventListener("DOMContentLoaded", function() {
    // Get all drop buttons and their corresponding drop elements
    const dropButtons = document.querySelectorAll(".drop-button");

    dropButtons.forEach(button => {
      button.addEventListener("click", function() {
        // Find the corresponding drop element for this button
        const targetElement = button.nextElementSibling;

        // Toggle the classes for the target element
        targetElement.classList.toggle("course-card-body");
        targetElement.classList.toggle("row");
      });
    });
  });
}

hoverOnCourse();