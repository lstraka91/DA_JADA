<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Profile</title>
</head>
<body>
	<div class="container">


		<jsp:include page="header.jsp"></jsp:include>
		<div class="row">

			<div class="container">
			<div class="panel panel-default">
			<div class="panel-body">
				<form method="post"
					action="/JADA_Tsystems_TeamProject/userProfile">
					<div id="profile">
						<h2 class="text-center formHead">
							Profile user ${sessionScope.user.fullName}
						</h2>
						<br>
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group row">

									<label for="username"
										class="col-sm-3 col-form-label">
										<b>User name :</b>
									</label>
									<div class="col-sm-9">
										<input type="text" id="username"
											name="username" value="${sessionScope.user.personName}"
											class="form-control input-lg" required disabled>
									</div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group row">

									<label for="fullname"
										class="col-sm-3 col-form-label">
										<b>Full name :</b>
									</label>
									<div class="col-sm-9">
										<input type="text" id="fullname"
											name="fullname" value="${sessionScope.user.fullName}"
											class="form-control input-lg" required disabled>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group row">
									<label for="email"
										class="col-sm-3 col-form-label">
										<b>Email address :</b>
									</label>
									<div class="col-sm-9">
										<input type="email" id="email"
											name="email" value="${sessionScope.user.email}"
											class="form-control input-lg" required disabled>
									</div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group row">

									<label for="birthday"
										class="col-sm-3 col-form-label">
										<b>Birthday :</b>
									</label>
									<div class="col-sm-9">
										<fmt:formatDate
											value="${sessionScope.user.birthday}" pattern="dd.MM.yyyy"
											var="birthDate" />
										<input type="text" id="birthday"
											value="${birthDate}" name="birthday"
											class="form-control input-lg" required disabled>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="row">

						<div id="passwordField"
							class="col-lg-4 col-lg-offset-4 center">
							<h2 class="text-center formHead">
								Change password
							</h2>
							<br>
							<div class="form-group row">
								<div id="oldpassword"></div>
								<label for="oldpass"
									class="col-form-label">
									<b>Old password:</b>
								</label>
								<input type="password"
									placeholder="Insert old password" id="oldpass" name="oldpass"
									class="form-control input-lg" required>
							</div>
							<div class="form-group row">
								<label for="passsword"
									class="col-form-label">
									<b>New password:</b>
								</label>
								<input type="password"
									placeholder="Insert new password" id="passsword"
									name="password" class="form-control input-lg" required>
								<div id="passsCheck"></div>
							</div>
							<div class="form-group row">
								<label for="confirm_passsword"
									class="col-form-label">
									<b>New password again:</b>
								</label>
								<input type="password"
									placeholder="Retype new password" id="confirm_passsword"
									name="confirm_password" class="form-control input-lg" required>
								<div id="passsValidation"></div>
							</div>
						</div>
					</div>


					<center>
						<input type="button" id="edit"
							value="Edit profile" class="btn btn-lg btn-primary">
						<input type="submit"
							class="btn btn-lg btn-primary" id="ssave" name="save"
							value="Save changes">
						<input type="button" id="changePass"
							value="Change password" class="btn btn-lg btn-warning ">
						<input type="button" id="back" value="Cancel"
							class="btn btn-lg btn-primary">
					</center>
				</form>
			</div>
			</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src='js/profileForm.js'></script>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>