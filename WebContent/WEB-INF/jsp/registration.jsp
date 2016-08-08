<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<link
	href='https://fonts.googleapis.com/css?family=Indie+Flower|Candal|Sigmar+One'
	rel='stylesheet' type='text/css'>
<script src="js/usernameExists.js"></script>
<link rel="stylesheet" href="css/style.css">
<title>Welcome to Game Center</title>
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
						<h2 class="text-center">Registration form</h2>

						<center>
							<div class="form-group">

								<input type="text" name="userName"  id="userName"
									placeholder="Insert your username here"
									class="form-control input-lg" required />
									<div id="status" ></div>
							</div>
							<div class="form-group">

								<input type="text" name="fullName" value=""
									placeholder="Insert your fullName"
									class="form-control input-lg" />
							</div>
							<div class="form-group">

								<input type="text" name="birthDate" value=""
									placeholder="Insert your DateOfBirth here"
									class="form-control input-lg" required />
							</div>
							<div class="form-group">

								<input type="password" name="Password" value=""
									placeholder="Insert your password here"
									class="form-control input-lg" id="password" minlength="6"
									required />
							</div>
							<div class="form-group">

								<input type="password" name="PasswordC" value=""
									placeholder="Confirm password" class="form-control input-lg"
									id="confirm_password" required />
							</div>

							<div class="form-group">

								<input type="email" name="Email" value=""
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
</body>
</html>


