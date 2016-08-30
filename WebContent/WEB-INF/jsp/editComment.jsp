<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

						<p class="pull-right">
							<fmt:formatDate value="${currentTopic.topicDate}"
								pattern="dd.MM.yyyy HH:mm" />
						</p>
						<c:forEach items="${currentTopic.keyWords}" var="keyword">
							<button class="btn btn-sm-info">${keyword.keyWord }</button>
						</c:forEach>
					</tr>
					<hr>

					<!-- My implementation of comments with rating -->
					<c:forEach items="${commentWithRateList}" var="commRate"
						varStatus="myindex">
						<p>
							<c:choose>
								<c:when
									test="${commRate.comment.person.personName eq user.personName or user.getClass().simpleName eq 'SuperAdmin'}">
									<span class="pull-right"><a
										href="topic?idTopic=${currentTopic.idTopic}&delete=true&idComment=${commRate.comment.idCommentary}"
										class="btn btn-danger"><span
											class="glyphicon glyphicon-remove-sign"></span></a> </span>
									<br>
								</c:when>
								<c:when test="${user.getClass().simpleName eq 'Admin'}">
									<c:if
										test="${user.deleteCommentPermission}">
										<span class="pull-right"><a
											href="topic?idTopic=${currentTopic.idTopic}&delete=true&idComment=${commRate.comment.idCommentary}"
											class="btn btn-danger"><span
												class="glyphicon glyphicon-remove-sign"></span></a> </span>
										<br>
									</c:if>
								</c:when>
							</c:choose>


						</p>




						<p>${commRate.comment.commentaryBody}</p>


						<p>
							<span class="pull-right">
								(${commRate.comment.person.fullName}) </span>
						</p>
						<fmt:parseNumber var="rate" value="${commRate.rateOfComment}" />
						<div class="row">

							<div class="col-md-5 offset-md-5">
								<span class="badge "><span
									class="glyphicon glyphicon-info-sign"></span>
									${commRate.countOfCommentsRating} times rated</span>
								<c:if test="${user!=null}">
									<a
										href="topic?idTopic=${currentTopic.idTopic}&addRate=like&idComment=${commRate.comment.idCommentary}"
										class="btn btn-default"><span
										class="glyphicon glyphicon-thumbs-up"></span>Like</a>
								</c:if>
								<c:if test="${rate>0}">
									<span class="label label-success">${commRate.rateOfComment}</span>

								</c:if>
								<c:if test="${rate==0}">
									<span class="label label-default">${commRate.rateOfComment}</span>
								</c:if>
								<c:if test="${rate<0}">
									<span class="label label-danger">${commRate.rateOfComment}</span>
								</c:if>
								<c:if test="${user!=null}">
									<a
										href="topic?idTopic=${currentTopic.idTopic}&addRate=dislike&idComment=${commRate.comment.idCommentary}"
										class="btn btn-default"><span
										class="glyphicon glyphicon-thumbs-down"></span>Dislike</a>
								</c:if>
							</div>
						</div>
						<span class="pull-right">commented <strong><fmt:formatDate
									value="${commRate.comment.commentaryDate}"
									pattern="dd.MM.yyyy HH:mm" /></strong></span>
						<br>
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
						<textarea name="comment" spellcheck="true" rows="3" required
							title="Content." maxlength="254" placeholder="Article content"
							class="form-control input-lg"></textarea>
						<br> <input type="submit" value="Add Comment"
							class="btn btn-primary ">
					</form>
				</div>
			</c:when>
			<c:otherwise>
				<center>
					<div class="alert alert-warning" role="alert">
						<span class="glyphicon glyphicon-exclamation-sign"
							aria-hidden="true"></span> <span class="sr-only">Info:</span>You
						must be logged in to comment topic
					</div>
				</center>
			</c:otherwise>
		</c:choose>
		<!-- Try to add MODAL TO EDIT -->
		<!-- Modal -->
		<div id="editComment" class="modal fade" role="dialog"
			data-backdrop="static" data-keyboard="false">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">

						<h4 class="modal-title">Edit comment</h4>
					</div>
					<div class="modal-body">
						<div class="panel">
							<div class="panel-body">
								<form method="post">
									<input type="hidden" name="idTopic" value="${idTopic}">
									<input type="hidden" name="idComment" value="${idCommentary}">
									<label for="comment"> Comment: </label> <br>
									<textarea name="editComment" spellcheck="true" rows="3"
										required title="Content." maxlength="254"
										placeholder="Article content" class="form-control input-lg">${commentaryBody}
										</textarea>

									<br> <input type="submit" value="Save change"
										class="btn btn-primary ">
								</form>
							</div>
						</div>

					</div>
					<div class="modal-footer">
						<a href="topic?idTopic=${idTopic}"
							class="btn btn-default">Close</a>

					</div>
				</div>

			</div>
		</div>
		<!--end of modal  -->


		<jsp:include page="footer.jsp"></jsp:include>

	</div>

</body>

<script type="text/javascript">
	$(window).load(function() {
		$('#editComment').modal('show');
	});
</script>
</html>
