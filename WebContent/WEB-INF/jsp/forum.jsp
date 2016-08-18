<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="now" class="java.util.Date" />
<jsp:useBean id="commentService"
	class="sk.tsystems.jada.forum.entity.services.CommentaryService" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forum-JADA</title>

<link href="css/jquery-ui.css" rel="stylesheet" type="text/css">
<link href="css/jquery.tagit.css" rel="stylesheet" type="text/css">
<link href="css/tagit.ui-zendesk.css" rel="stylesheet" type="text/css">


</head>
<body>
	<div class="container">

		<jsp:include page="header.jsp"></jsp:include>

		
			<div class="panel panel-default">
				<div class="panel-body">

					<ul class="nav nav-tabs navbar-right">

						<c:choose>
							<c:when test="${sorting==2 }">
								<li role="presentation"><a
									href="/JADA_Tsystems_TeamProject/forum?action=new">new</a></li>
								<li role="presentation" class="active"><a
									href="/JADA_Tsystems_TeamProject/forum?action=top">top
										viewed</a></li>
								<li role="presentation"><a
									href="/JADA_Tsystems_TeamProject/forum?action=mostcommented">most
										commented</a></li>
							</c:when>

							<c:when test="${sorting==3 }">
								<li role="presentation"><a
									href="/JADA_Tsystems_TeamProject/forum?action=new">new</a></li>
								<li role="presentation"><a
									href="/JADA_Tsystems_TeamProject/forum?action=top">top
										viewed</a></li>
								<li role="presentation" class="active"><a
									href="/JADA_Tsystems_TeamProject/forum?action=mostcommented">most
										commented</a></li>
							</c:when>
							<c:otherwise>
								<li role="presentation" class="active"><a
									href="/JADA_Tsystems_TeamProject/forum?action=new">new</a></li>
								<li role="presentation"><a
									href="/JADA_Tsystems_TeamProject/forum?action=top">top
										viewed</a></li>
								<li role="presentation"><a
									href="/JADA_Tsystems_TeamProject/forum?action=mostcommented">most
										commented</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
					<div class="table">
						<table class="table table-hover">
							<thead>

							</thead>
							<tbody id="myTable">
								<c:forEach items="${topics}" var="topic">
									<tr>
										<td><div class="text-center">
												<div class="center">
													<div>
														<c:choose>
															<c:when test="${topic.viewersList!=null }">
															${topic.viewersList.stream().count()}
															</c:when>
															<c:otherwise>0</c:otherwise>
														</c:choose>
													</div>
													<div>Views</div>

												</div>
												<div class="center">
													<div>
														<c:choose>
															<c:when
																test="${commentService.selectAllComentByTopic(topic)!=null }">
															${commentService.selectAllComentByTopic(topic).stream().count() }
															</c:when>
															<c:otherwise>0</c:otherwise>
														</c:choose>

													</div>
													<div>Comments</div>
												</div>
											</div></td>
										<td colspan="10"><div class="row">
												<a
													href="/JADA_Tsystems_TeamProject/topic?idTopic=${topic.idTopic }">${topic.topicName }</a>
											</div>
											<div class="row">
												<c:choose>
													<c:when test="${not empty topic.keyWords }">
														<c:forEach items="${topic.keyWords}" var="keyword">
															<button class="btn btn-sm-info disabled">${keyword.keyWord }</button>
														</c:forEach>
													</c:when>
													<c:otherwise>
														<p>key words not defined.</p>
													</c:otherwise>
												</c:choose>
											</div></td>
										<td>(${topic.person.personName })</td>

										<td><c:choose>
												<c:when test="${now.date gt topic.topicDate.date}">
													<p>
														<fmt:formatDate value="${topic.topicDate}"
															pattern="dd.MMM yyy HH:mm" />
													</p>
												</c:when>
												<c:otherwise>
													<time class="timeago" datetime="${topic.topicDate}">just
													now</time>
												</c:otherwise>
											</c:choose></td>
										<td><c:if
												test="${user.getClass().simpleName eq 'SuperAdmin' || user.getClass().simpleName eq 'Admin'}">
												<c:if test="${user.deleteTopicPermission }">
													<a href="editTopic?idTopic=${topic.idTopic}"
														class="btn btn-warning btn-block"> <span
														class="glyphicon glyphicon-edit" aria-hidden="true"></span>
														Edit
													</a>
													<a href="forum?idTopicDelete=${topic.idTopic}"
														class="btn btn-danger btn-block"> <span
														class="glyphicon glyphicon-delete" aria-hidden="true"></span>
														Delete
													</a>
												</c:if>
											</c:if></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="col-md-12 text-center">
						<ul class="pagination pagination-md pager" id="myPager"></ul>
					</div>
				</div>
			</div>
		



	<script type="text/javascript" src="js/jquery.timeago.js"></script>
	<script type="text/javascript" src="js/forumScripts.js"></script>
	<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>