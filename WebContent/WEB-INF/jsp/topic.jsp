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
			<div class="panel-heading nav navbar-default">
				<div class="topicShow">
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
					<hr>


				</div>
				<c:if test="${!empty commentWithRateList}">
					<ul class="nav navbar-nav navbar-right">

						<li><a
							href="/JADA_Tsystems_TeamProject/topic?idTopic=${currentTopic.idTopic }&orderBy=new">
								newest </a></li>
						<li><a
							href="/JADA_Tsystems_TeamProject/topic?idTopic=${currentTopic.idTopic }&orderBy=rating">
								most rated </a></li>

					</ul>
				</c:if>
			</div>
			<div class="panel-body">

				<!-- My implementation of comments with rating -->
				<c:forEach items="${commentWithRateList}" var="commRate"
					varStatus="myindex">
					<div>
						<c:choose>
							<c:when
								test="${commRate.comment.person.personName eq user.personName or user.getClass().simpleName eq 'SuperAdmin'}">
								<div class="text-right">
									<div class="btn-group">
										<span class="pull-right"> <a
											href="topic?idTopic=${currentTopic.idTopic}&delete=true&idComment=${commRate.comment.idCommentary}"
											class="btn btn-danger"> <span
												class="glyphicon glyphicon-remove-sign"> </span> Delete
										</a>
										</span> <a
											href="editComment?idTopic=${currentTopic.idTopic}&idComment=${commRate.comment.idCommentary}&commentaryBody=${commRate.comment.commentaryBody}"
											class="btn btn-warning"> <span
											class="glyphicon glyphicon-edit"> </span> Edit
										</a>
									</div>
								</div>
								<br>
							</c:when>
							<c:when test="${user.getClass().simpleName eq 'Admin'}">

								<c:if test="${user.deleteCommentPermission}">

									<div class="text-right">
										<div class="btn-group">
											<span class="pull-right"> <a
												href="topic?idTopic=${currentTopic.idTopic}&delete=true&idComment=${commRate.comment.idCommentary}"
												class="btn btn-danger"> <span
													class="glyphicon glyphicon-remove-sign"> </span> Delete
											</a>
											</span> <a
												href="editComment?idTopic=${currentTopic.idTopic}&idComment=${commRate.comment.idCommentary}&commentaryBody=${commRate.comment.commentaryBody}"
												class="btn btn-warning"> <span
												class="glyphicon glyphicon-edit"> </span> Edit
											</a>
										</div>
									</div>
									<br>
								</c:if>
							</c:when>
						</c:choose>
					</div>
					<!-- Try to add MODAL TO EDIT -->

					<div id="idComment${ myindex.index }" class="commentBody">

						<p>${commRate.comment.commentaryBody}</p>
					</div>

					<div class="pull-right text-center">
						<div>
							<img class="headimg" alt="head" src="images/headimg.png">
						</div>
						<div>(${commRate.comment.person.fullName})</div>
					</div>
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

		<jsp:include page="footer.jsp"></jsp:include>

	</div>
	<script
		src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
	<script src='js/dataTables.js'></script>
</body>


</html>
