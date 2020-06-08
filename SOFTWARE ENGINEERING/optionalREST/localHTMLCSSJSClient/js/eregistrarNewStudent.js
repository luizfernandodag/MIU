
"use strict";

$(document).ready(
		function() {

			// SUBMIT FORM
			$("#newStudentForm").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();
			});

			function ajaxPost() {



				// PREPARE FORM DATA
				var formData = {
					studentNumber : $("#studentNumber").val(),
					firstName : $("#firstName").val(),
					middleName: $("#middleName").val(),
					lastName: $("#lastName").val(),
					cpga: $("#cpga").val(),
					transcript: $("#transcript").val(),
					dateOfEnrollment: $("#dateOfEnrollment").val(),
					isInternational: $("#isInternational").val()

				}
			
				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "http://localhost:8079/eregistrar/api/student/register",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						if (result.status == "success") {
							
							$("#postResultDiv").html(
									"" + result.data
											+ "Post Successfully! <br>"
											+ "---> Congrats !!" + "</p>");
						} else {
							$("#postResultDiv").html("<strong>Error</strong>");
						}
						console.log(result);
					},
					error : function(e) {
						alert("Error!")
						console.log("ERROR: ", e);
					}
				});
				alert("sucess");
				window.location = "../student/list.html";
			}

		})