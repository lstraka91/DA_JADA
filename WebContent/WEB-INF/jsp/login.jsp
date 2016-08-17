<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Please log in</title>
</head>
<body>
	<div class="container">

		<jsp:include page="header.jsp" />

		<!-- 
		<c:if test="${not empty param.error}">
			<div class="alert alert-danger" role="alert">
				<strong>Login Error!</strong> Invalid username or password, try
				again.
			</div>
		</c:if>
 -->
		<div class="row">
			<div class="center-form panel">
				<form method="post">
					<div class="panel panel-default">
						<div class="panel-body">
							<h2 class="text-center formHead">Please log in</h2>

							<center>
								<div class="form-group">
									<div id="failedLogin"></div>
									<input type="text" name="userName" value="" id="username"
										placeholder="Insert your username here"
										class="form-control input-lg" required autofocus /> <input
										type="password" name="password" value="" id="pass"
										placeholder="Insert your password here"
										class="form-control input-lg" requried />
								</div>
								<div id="status"></div>
								<input type="button" value="Login" id="login"
									class="btn btn-lg btn-block btn-success" /> <a
									href="/JADA_Tsystems_TeamProject/registration"
									class="btn btn-lg btn-block btn-primary">Register</a>


							</center>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script src="js/login.js"></script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>


