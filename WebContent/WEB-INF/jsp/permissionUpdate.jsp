<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forum-JADA</title>
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp"></jsp:include>

		<div class="panel panel-default">
			<div class="panel-body">
				<table id="adminsList" class="display" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Admins</th>
							<!-- 							<th>description</th> -->
							<!-- 							<th>date</th> -->
							<!-- 							<th>author</th> -->
							<!-- 							<th>keywords</th> -->
						</tr>
					</thead>
					<c:forEach items="${admins}" var="admins">
						<tr>
							<%-- 							<td>${topic.topicName }</td> --%>
							<%-- 							<td>${topic.topicDescription}</td> --%>
							<%-- 							<td>${topic.topicDate }</td> --%>
							<%-- 							<td>${topic.person.personName }</td> --%>
							<%-- 							<td>${keyword.keyWord }</td> --%>

							<td><div class="media-body">

									<h3>
										${admins.personName }<span class="pull-right">(${admins.fullName })</span>
									</h3>
<%-- 									<p>${topic.topicDescription}</p> --%>
<%-- 									<span class="pull-right">${topic.topicDate }</span> --%>
<%-- 									<c:forEach items="${topic.keyWords}" var="keyword"> --%>
<%-- 										<button class="btn btn-sm-info">${keyword.keyWord }</button> --%>
<%-- 									</c:forEach> --%>
								</div></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>







	</div>



</body>
</html>