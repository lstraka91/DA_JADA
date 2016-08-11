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
			<h2 class="text-center formHead">Profile user
				${sessionScope.user.fullName}</h2>
			<br>
			<div class="container">
				<form method="post" action="/JADA_Tsystems_TeamProject/userProfile">
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group row">

								<label for="username" class="col-sm-3 col-form-label"> <b>User
										name :</b>
								</label>
								<div class="col-sm-9">
									<input type="text" id="username" name="username"
										value="${sessionScope.user.personName}"
										class="form-control input-lg" required disabled>
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group row">

								<label for="fullname" class="col-sm-3 col-form-label"> <b>Full
										name :</b>
								</label>
								<div class="col-sm-9">
									<input type="text" id="fullname" name="fullname"
										value="${sessionScope.user.fullName}"
										class="form-control input-lg" required disabled>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group row">
								<label for="email" class="col-sm-3 col-form-label"> <b>Email
										address :</b>
								</label>
								<div class="col-sm-9">
									<input type="email" id="email" name="email"
										value="${sessionScope.user.email}"
										class="form-control input-lg" required disabled>
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group row">

								<label for="birthday" class="col-sm-3 col-form-label"> <b>Birthday
										:</b>
								</label>
								<div class="col-sm-9">
									<fmt:formatDate value="${sessionScope.user.birthday}"
										pattern="dd.MM.yyyy" var="birthDate" />
									<input type="text" id="birthday" value="${birthDate}"
										name="birthday" class="form-control input-lg" required disabled>
								</div>
							</div>
						</div>
					</div>



					<center>
						<input type="button" id="edit" value="Edit profile"
							class="btn btn-lg btn-primary"> <input type="submit"
							class="btn btn-lg btn-primary" id="save" value="Save changes">
						<a href="userProfile?password=allowed"
							class="btn btn-lg btn-warning "> Change password </a> <input
							type="button" id="back" value="Cancel"
							class="btn btn-lg btn-primary">
					</center>
				</form>
			</div>
		</div>
	</div>
	<script src='js/profileForm.js'></script>
</body>
</html>