<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<div class="container">

		<jsp:include page="header.jsp" />


		<c:if test="${not empty param.error}">
			<div class="alert alert-danger" role="alert">
				<strong>Registration Error!</strong> Username allready exist, change
				the username.
			</div>
		</c:if>
		<div class="row">
			<div class="center-form panel">
				<form method="post" action="/JADA_Tsystems_TeamProject/registration">
					<div class="panel-body">
						<h2 class="text-center formHead">Registration form</h2>

						<center>
							<div class="form-group">

								<input type="text" name="userName" id="userName"
									placeholder="Insert your username here"
									class="form-control input-lg" required />
								<div id="status"></div>
							</div>
							<div class="form-group">

								<input type="text" name="fullName"
									placeholder="Insert your fullName"
									class="form-control input-lg" required />
							</div>
							<div class="form-group">

								<input type="text" name="birthDate" id="datepicker" value=""
									placeholder="Insert your DateOfBirth here"
									class="form-control input-lg" required autocomplete=off/>
							</div>
							<div class="form-group">

								<input type="password" name="Password" id="password"
									placeholder="Insert your password here"
									class="form-control input-lg" id="password" minlength="6"
									required />
								<div id="passCheck"></div>
							</div>
							<div class="form-group">

								<input type="password" name="PasswordC"
									placeholder="Confirm password" class="form-control input-lg"
									id="confirm_password" required />
							</div>

							<div class="form-group">

								<input type="email" name="Email"
									placeholder="Insert your email address"
									class="form-control input-lg" required />
							</div>
							<input type="submit" value="Register user" id="register"
								class="btn btn-lg btn-block btn-success" /> <a
								href="/JADA_Tsystems_TeamProject/login"
								class="btn btn-lg btn-block btn-primary">Back to Login</a>
						</center>
					</div>
				</form>
			</div>
		</div>

	</div>
	<script type="text/javascript">
		var password = document.getElementById("password"), confirm_password = document
				.getElementById("confirm_password");

		function validatePassword() {
			if (password.value != confirm_password.value) {
				confirm_password.setCustomValidity("Passwords Don't Match");
			} else {
				confirm_password.setCustomValidity('');
			}
		}

		password.onchange = validatePassword;
		confirm_password.onkeyup = validatePassword;
	</script>

	<script>
		$(document).ready(function() {
			$("#datepicker").datepicker({ dateFormat: 'dd-mm-yy',changeMonth: true,
			      changeYear: true,yearRange: "1900:+nn" });
			 

		});
	</script>
	<script src="js/usernameExists.js"></script>
	<script src="js/checkPasswordStrong.js"></script>
</body>
</html>


