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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Topic</title>

<link href="css/jquery-ui.css" rel="stylesheet" type="text/css">
<link href="css/jquery.tagit.css" rel="stylesheet" type="text/css">
<link href="css/tagit.ui-zendesk.css" rel="stylesheet" type="text/css">

</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp"></jsp:include>

		<form method="get">
					<h3 class="formHead text-center">Edit question</h3>
			<div class="panel panel-default">
				<div class="panel-body">
					<label>Topic name :</label> <input type="text" id="topicname"
						name="topicname" value="${currentTopic.topicName}"
						class="form-control input-lg"> <label>Topic
						description :</label>
					<textarea id="topicdescription" name="topicdescription"
						class="form-control input-lg">${currentTopic.topicDescription}</textarea>
					<label>Topic keywords</label>


					<ul id="keyWords">
						<c:forEach items="${currentTopic.keyWords}" var="keyword">
							<li class="btn btn-sm-info">${keyword.keyWord }</li>
						</c:forEach>
					</ul>
					<input type="hidden" name="idTopic" value="${currentTopic.idTopic}">
					<center>
						<button type="submit" class="btn btn-lg btn-success ">
							<span class="glyphicon glyphicon-comment " aria-hidden="true">
							</span> Save changes
						</button>
						<a href="forum" class="btn btn-lg btn-primary"> Cancel </a>
					</center>
				</div>
			</div>
		</form>

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