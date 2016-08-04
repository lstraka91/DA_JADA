<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<div class="row">
	<div class="row text-center">
		<img src="images/title.jpg" alt="title" width="100%" height="200rem">
	</div>
</div>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<a class="navbar-brand" href="/GameStudioWeb/GameStudio">Forum JADA</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">

			<ul class="nav navbar-nav navbar-right">

				<%-- 				<c:choose> --%>
				<%-- 					<c:when test="${player == null}"> --%>
				<li><a href="/GameStudioWeb/login?">Login</a></li>
				<%-- 					</c:when> --%>
				<%-- 					<c:otherwise> --%>
				<li>
					<p class="navbar-text">
						Signed in as <a href="#" class="navbar-link">player</a>
					</p>
				</li>
				<li><a href="?action=logout">Logout</a></li>
				<%-- 					</c:otherwise> --%>
				<%-- 				</c:choose> --%>

			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>

