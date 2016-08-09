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


		<div class="container">
			<h2>Table</h2>
			<p>The .table-responsive class creates a responsive table which
				will scroll horizontally on small devices (under 768px). When
				viewing on anything larger than 768px wide, there is no difference:</p>
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>AdminName</th>
							<th>DeleteComment</th>
							<th>DeleteTopic</th>
							<th>DeleteUser</th>
							<th>ActivateUser</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${admins}" var="admins" varStatus="theCount">
							<tr>
								<td>${theCount.index +1}</td>
								<td>${admins.personName }</td>

								<td><c:if test="${admins.deleteCommentPermission == true}">
										<p>YES</p>
									</c:if> <c:if test="${admins.deleteCommentPermission == false}">
										<p>NO</p>
									</c:if></td>

								<td><c:if test="${admins.deleteTopicPermission == true}">
										<p>YES</p>
									</c:if> <c:if test="${admins.deleteTopicPermission == false}">
										<p>NO</p>
									</c:if></td>

								<td><c:if test="${admins.deleteUserPermission == true}">
										<p>YES</p>
									</c:if> <c:if test="${admins.deleteUserPermission == false}">
										<p>NO</p>
									</c:if></td>

								<td><c:if test="${admins.activationUserPernmision == true}">
										<p>YES</p>
									</c:if> <c:if test="${admins.activationUserPernmision == false}">
										<p>NO</p>
									</c:if></td>



							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>


	</div>



</body>
</html>