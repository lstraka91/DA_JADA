<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="now" class="java.util.Date" />
<jsp:useBean id="topicService"
	class="sk.tsystems.jada.forum.entity.services.TopicService" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forum-JADA</title>

<!-- <link rel="stylesheet" type="text/css" -->
<!-- 	href="css/jquery.dataTables.min.css"> -->


</head>
<body>
	<div class="container">


		<jsp:include page="header.jsp"></jsp:include>

		<div class="panel panel-default">
			<div class="panel-body">
				<ul class="nav nav-tabs navbar-right">
					<li><a href="/JADA_Tsystems_TeamProject/forum?action=new">new</a></li>
					<li><a href="/JADA_Tsystems_TeamProject/forum?action=top">top
							viewed</a></li>
					<li><a
						href="/JADA_Tsystems_TeamProject/forum?action=mostcommented">most
							commented</a></li>
				</ul>
				<!-- 				<table id="topicList" class="table table-inverse"> -->
				<table class="table table-striped table-inverse">
					<c:forEach items="${topics}" var="topic">
						<tr>
							<td><div class="text-center">
									<div>
										<div class="center">
											${topic.viewersList.stream().count()}</div>
										<div>Views</div>

									</div>
									<div class="center">
										<div>3 - not working</div>
										<div>Comments</div>
									</div>
								</div></td>
							<td colspan="10"><a
								href="/JADA_Tsystems_TeamProject/topic?idTopic=${topic.idTopic }">${topic.topicName }</a>

								<p>${topic.topicDescription}</p> <c:forEach
									items="${topic.keyWords}" var="keyword">
									<button class="btn btn-sm-info disabled">${keyword.keyWord }</button>
								</c:forEach></td>
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

						</tr>

					</c:forEach>
				</table>
			</div>
		</div>



		<div class="content-footer">
			<p>
				JadaForum © - 2016 <br> Powered By <a href="#" target="_blank">JaDA</a>
			</p>
		</div>
	</div>

	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.timeago.js"></script>
	<script type="text/javascript">
		jQuery(document).ready(function() {
			jQuery("time.timeago").timeago();
		});

		$(function() {
			$("li").click(function() {
				// remove classes from all
				$("li").removeClass("active");
				// add class to the one we clicked
				$(this).addClass("active");
			});
		});
	</script>
</body>
</html>