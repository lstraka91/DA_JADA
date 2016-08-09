<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!-- Latest compiled and minified CSS -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>


<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- <div class="row">
			<img src="images/title.png" alt="title" height="200rem">
	<h1 class="display-1">JADA - Forum</h1>
</div> -->
<div class="jumbotron">
        <div class="row">
            <div class="col-md-2 col-lg-2">
                <img src="images/qaa.png" alt="JADA" class="img-responsive">
            </div>
            <div class="col-md-9 col-lg-9">
                <h1 class="text-center text-primary">JaDa - FORUM </h1>
            </div>
        </div>
        <p class="text-center jumbotext" >Join to our community and ask for help if you had a trouble !! <span class="glyphicon glyphicon-thumbs-up"></span></p>
</div>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">JADA</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="forum">Home</a></li>
				<li><a href="#">About</a></li>
				<li><a href="#">Projects</a></li>
				<li><a href="#">Contact</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${sessionScope.user!=null}">
						<li><a href="#"><span
								class="glyphicon glyphicon-user"></span>
								${sessionScope.user.fullName } </a></li>
						<li><a href="logout"><span
								class="glyphicon glyphicon-log-in"></span> Log Out</a></li>

					</c:when>
					<c:otherwise>

						<li><a href="login"><span
								class="glyphicon glyphicon-log-in"></span> Log in</a></li>
						<li><a href="registration"><span
								class="glyphicon glyphicon-log-in"></span> Registration</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</nav>

 


