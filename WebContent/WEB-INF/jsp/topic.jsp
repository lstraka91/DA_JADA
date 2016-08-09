<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Topic-JADA</title>


</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp"></jsp:include>

		<div class="panel panel-default">
			<div class="panel-body">
				<table cellspacing="0" width="100%">

					<tr>
						<h3>
							<span>${currentTopic.topicName}</span> <span class="pull-right">(${currentTopic.person.personName})</span>
						</h3>
						<p>${currentTopic.topicDescription}</p>
						<p class="pull-right">${currentTopic.topicDate }</p>
						<c:forEach items="${currentTopic.keyWords}" var="keyword">
							<button class="btn btn-sm-info">${keyword.keyWord }</button>
						</c:forEach>
					</tr>
					<hr>
					<c:forEach items="${topicComments}" var="comment">
						<p>${comment.commentaryBody}</p>
						<h4>
							<span>${comment.commentaryDate}</span> <span class="pull-right">(${comment.person.fullName})</span>
						</h4>
						<a href="topic?idTopic=${currentTopic.idTopic}&addRate=like&idComment=${comment.idCommentary}">Like</a>
						<hr>
					</c:forEach>

				</table>
			</div>
		</div>

		<c:choose>
			<c:when test="${user != null}">
				<div>
					<form>
						<input type="hidden" name="idTopic"
							value="${currentTopic.idTopic}"> <label for="comment">Comment:</label>
						<br>
						<textarea name="comment" spellcheck="true" rows="3"
							required title="Content." maxlength="254"
							placeholder="Article content" class="form-control input-lg"></textarea>
						<br> <input type="submit" value="Add Comment" class="btn btn-primary ">
					</form>
				</div>
			</c:when>
			<c:otherwise>
				<center>
					<div class="alert alert-warning" role="alert">
					<span class="glyphicon glyphicon-exclamation-sign"
						aria-hidden="true"></span> <span class="sr-only">Info:</span>You must be logged in to comment topic</div>
				</center>
			</c:otherwise>
		</c:choose>
		<hr>
		<div class="content-footer">
			<p>
				JadaForum © - 2016 <br> Powered By <a href="#" target="_blank">JaDA</a>
			</p>
		</div>

	</div>
	<script src="//code.jquery.com/jquery-1.12.3.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
	<script src='js/dataTables.js'></script>
</body>
</html>
