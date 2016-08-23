$(function() {
	$("#loginForm").on('submit',(function(event) {
		event.preventDefault();
						var username = $("#username").val();
						var pass = $("#pass").val();
						$("#loginStatus").html('<img src="images/loader.gif" align="absmiddle">&nbsp; Trying to log in...');
						$.ajax({	type : "POST",
									url : "loginCheck",
									data : "userName=" + username
											+ "&password=" + pass,
									success : function(msg) {
										console.log(msg);
										if (msg === 'error') {
											$("#failedLogin")
													.html(
															'<div class="alert alert-danger" role="alert"><strong><span class="glyphicon glyphicon-exclamation-sign"></span> Login Error!</strong> Invalid username or password, try again!!!</div>');
											$("#loginStatus").html('');
										} else if (msg === 'notActivated') {
											$("#failedLogin")
													.html(
															'<div class="alert alert-danger" role="alert"><strong><span class="glyphicon glyphicon-exclamation-sign"></span> Not aproved user!</strong> Admin have to activate your acount!!!</div>');
											$("#loginStatus").html('');
											setTimeout( function() { $( "#login" ).modal( "hide" ) }, 30000 );
										} else {
											document.location = "forum"
										}
									}
						});
			}));
});
