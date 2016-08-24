<%@page import="sk.tsystems.jada.forum.entity.services.KeyWordService"%>
<%@page import="sk.tsystems.jada.forum.entity.KeyWord"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ask question</title>


<link href="css/jquery-ui.css" rel="stylesheet" type="text/css">
<link href="css/jquery.tagit.css" rel="stylesheet" type="text/css">
<link href="css/tagit.ui-zendesk.css" rel="stylesheet" type="text/css">


</head>
<body>


	<div class="container">
		<jsp:include page="header.jsp"></jsp:include>

		<c:choose>
			<c:when test="${user!=null }">
				<form>
							<h3 class="formHead text-center">Ask new question </h3>
					<div class="panel panel-default">
						<div class="panel-body">
							<input type="hidden" name="action" value="addtopic"><b><br>
								Enter keywords other users can find your question:<br></b>
							<ul id="keyWords">

							</ul>
							<b> <br>Ask question to start new topic:
							</b><br> <input type="text" class="form-control"
								placeholder="Topic name" maxlength="254" name="topicName" required><b><br>Describe
								your problem: </b><br>

							<textarea name="topicDesc" type="text" class="form-control"
								placeholder="Write description..." maxlength="254" id="topicDesc" required></textarea>
							<br>
							<center>
								<button type="submit" class="btn btn-lg btn-success ">
									<span class="glyphicon glyphicon-comment " aria-hidden="true"></span>
									Share new question
								</button>
								<a href="forum" class="btn btn-lg btn-primary"> Cancel </a>
							</center>
						</div>
					</div>
				</form>
			</c:when>
			<c:otherwise>
				<center>
					<div class="alert alert-warning" role="alert">
						<span class="glyphicon glyphicon-exclamation-sign"
							aria-hidden="true"></span> <span class="sr-only">Info:</span>You
						must be logged in to create topic !!! <a href="#"
							data-toggle="modal" data-target="#login">Go to login page </a>or<a
							href="#" data-toggle="modal" data-target="#registration">sign
							up as new user</a>
					</div>
				</center>
			</c:otherwise>
		</c:choose>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>

	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"
		type="text/javascript" charset="utf-8"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.12/jquery-ui.min.js"
		type="text/javascript" charset="utf-8"></script>

	<script src="js/tag-it.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">		
	$(document).ready(function() {
		$("#keyWords").tagit();
	});
	<%ArrayList<KeyWord> keyWords = new KeyWordService().getAllKeyWords();

			ArrayList<String> keyWordStrings = new ArrayList<>();
			for (KeyWord keyWord : keyWords) {
				keyWordStrings.add(keyWord.getKeyWord());
			}%>
	var jsArray = [<%for (int i = 0; i < keyWordStrings.size(); i++) {%>"<%=keyWordStrings.get(i)%>"<%=i + 1 < keyWordStrings.size() ? "," : ""%><%}%>];
</script>
	<script src="js/prototype.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>