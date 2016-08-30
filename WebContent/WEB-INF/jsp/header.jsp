<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!-- Latest compiled and minified CSS -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link
	href='https://fonts.googleapis.com/css?family=Indie+Flower|Candal|Sigmar+One|Nova+Square|Imprima'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.css" />
<link rel="stylesheet" href="css/style.css">

<!-- jQuery library -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script type="text/javascript"
	src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>

<!-- Latest compiled JavaScript -->
<script type="text/javascript"
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript" src="js/login.js"></script>

<!--  datatables  -->


<script type="text/javascript"
	src="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#datepicker").datepicker({
			dateFormat : 'dd.mm.yy',
			changeMonth : true,
			changeYear : true,
			yearRange : "1900:+nn"
		});
	});
</script>
<script type="text/javascript" src="js/usernameExists.js"></script>
<script type="text/javascript" src="js/checkPasswordStrong.js"></script>
<script type="text/javascript" src="js/validatePassword.js"></script>


<div id="jumbo" class="jumbotron">
	<div id="jumborow" class="row">
		<div class="col-md-2 col-lg-2">
			<img src="images/qaa.png" alt="JADA" class="img">
		</div>
		<div class="col-md-9 col-lg-9">
			<h1 class="text-center text-primary jumboHead">JaDa - FORUM</h1>
		</div>
	</div>
	<p class="text-center jumbotext">
		Join to our community and ask for help if you had a trouble <span
			class="glyphicon glyphicon-thumbs-up"></span>
	</p>
</div>



<nav class="navbar navbar-fixed-top navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="forum">JADA</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="newtopic"><span
						class="glyphicon glyphicon-question-sign"></span> ASK QUESTION</a></li>

				<c:if test="${user.getClass().simpleName.equals('Admin')}">
					<li class="dropdown"><a class="btn dropdown-toggle"
						type="button" data-toggle="dropdown">Admin menu <c:choose>
								<c:when test="${countOfNotifi > 0 }">
									<img src="images/notification.png" alt="admin" height="25"
										width="25">
								</c:when>
							</c:choose> <span class="caret"> </span>
					</a>

						<ul class="dropdown-menu">
							<li><a href="ShowUsers">Show all USERs <c:choose>
										<c:when test="${countOfNotifi > 0 }">
											<span class="badge red"> ${countOfNotifi}</span>
										</c:when>
									</c:choose>
							</a></li>
							<!-- 							<li><a href="showUsecase">Show usecase</a></li> -->
						</ul></li>
				</c:if>
				<c:if test="${user.getClass().simpleName.equals('SuperAdmin')}">
					<li class="dropdown"><a class="btn dropdown-toggle"
						type="button" data-toggle="dropdown">Admin menu <c:choose>
								<c:when test="${countOfNotifi > 0 }">
									<img src="images/notification.png" alt="admin" height="25"
										width="25">
								</c:when>
							</c:choose> <span class="caret"> </span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="ShowUsers">Show all USERs <c:choose>
										<c:when test="${countOfNotifi > 0 }">
											<span class="badge red"> ${countOfNotifi}</span>
										</c:when>
									</c:choose>

							</a></li>
							<li><a href="showAdminsPermission">Change admin
									permissions</a></li>
							<li><a href="changePersonType">Change User type</a></li>
							<!-- 							<li><a href="showUsecase">Show usecase</a></li> -->

						</ul></li>
				</c:if>

			</ul>

			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${sessionScope.user!=null}">
						<li><a href="userProfile"><span
								class="glyphicon glyphicon-user"></span>
								${sessionScope.user.fullName } </a></li>
						<li><a href="logout"><span
								class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
					</c:when>
					<c:otherwise>

						<li><a href="#" data-toggle="modal" data-target="#login"><span
								class="glyphicon glyphicon-log-in"></span> Log in</a></li>
						<li><a href="#" data-toggle="modal"
							data-target="#registration"><span
								class="glyphicon glyphicon-log-in"></span> Registration</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</nav>


<!-- Modal Login -->
<div class="modal fade data-backdrop="static" id="login" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h2 class="modal-title text-center formHead">
					Please log in
					</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="center-form panel">
						<form method="post" id="loginForm">
							<div class="panel panel-default">
								<div class="panel-body">
									<div class="form-group">
										<div id="failedLogin"></div>
										<input type="text" name="userName" value="" id="username"
											placeholder="Insert your username here"
											class="form-control input-lg" required autofocus /> <input
											type="password" name="password" value="" id="pass"
											placeholder="Insert your password here"
											class="form-control input-lg" requried />
									</div>
									<div id="loginStatus"></div>
									<input type="submit" value="Login" id="login"
										class="btn btn-lg btn-block btn-success" />



								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>

	</div>
</div>

<!-- Modal Registration-->
<div class="modal fade" id="registration" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h2 class="modal-title text-center formHead">Registration page
				</h2>
			</div>
			<div class="modal-body">
				<c:if test="${not empty param.error}">
					<div class="alert alert-danger" role="alert">
						<strong>Registration Error!</strong> Username allready exist,
						change the username.
					</div>
				</c:if>
				<div class="row">
					<div class="center-form panel">
						<form method="post"
							action="registration">
							<div class="panel panel-default">
								<div class="panel-body">
									<div class="form-group">
										<div class="alert alert-info" role="alert">
											<a href="#" class="close" data-dismiss="alert"
												aria-label="close">&times;</a><span
												class="glyphicon glyphicon-info-sign"></span>After register
											admin have to <strong>activate</strong> your account.You
											don't be able to login yet
										</div>
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
											class="form-control input-lg" required autocomplete=off />
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
										<div id="passValidation"></div>
									</div>
									<div class="form-group">
										<input type="email" name="Email"
											placeholder="Insert your email address"
											class="form-control input-lg" required />
									</div>
									<input type="submit" value="Register user" id="register"
										class="btn btn-lg btn-block btn-success" />
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>

	</div>
</div>

