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
					<input type="hidden" name="action" value="addtopic">
					Enter keywords other users can find your question:
					<ul id="keyWords">

					</ul>
					Ask question to start new topic:
					<input type="text" class="form-control" placeholder="Topic name"
						name="topicName" required>
					Describe your problem:
					<textarea name="topicDesc" type="text" class="form-control"
						placeholder="Write description..." id="topicDesc" required></textarea>
					<button type="submit" class="btn btn-success green">
						<span class="glyphicon glyphicon-comment " aria-hidden="true"></span>
						Share
					</button>
				</form>
			</c:when>
			<c:otherwise>
				<center>
				<center>
					<div class="alert alert-warning" role="alert">
						<span class="glyphicon glyphicon-exclamation-sign"
							aria-hidden="true"></span> <span class="sr-only">Info:</span>You
						must be logged in to create topic !!! <a href="login">Go to login page </a>or<a href="registration"> sign up as new user</a>
					</div>
				</center>
					<h4>You must be logged in to ask a question</h4>
				</center>
			</c:otherwise>
		</c:choose>
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
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>