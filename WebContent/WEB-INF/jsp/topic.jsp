<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!-- Latest compiled and minified CSS -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<div class="row">
	<div class="row">
		<!-- 		<img src="images/title.png" alt="title" height="200rem"> -->
		<h1 class="display-1">JADA - Forum</h1>
	</div>
</div>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">


		<h4>Comments for topic:</h4>
		<jsp:include page="/TopicServlet" flush="true" />
		<br> <br>

			<form>
				<label for="comment">Comment:</label> <br>
				<textarea name="comment" spellcheck="true" cols="52" rows="10"
					required title="Content." placeholder="Article content"></textarea>
				<br> <br> <input type="submit">
			</form>
		
		
	</div>
</nav>
