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
								<td><a href="UpdateAdmin?adminName=${admins.personName}"
									class="btn btn-danger"> <b><i>${admins.personName}</i></b>
								</a></td>

								<td><c:choose>
										<c:when test="${admins.deleteCommentPermission == true}">
											<img src="images/button_ok.png" alt="ok" height="16"
												width="16">
										</c:when>
										<c:otherwise>
											<img src="images/button_cancel.png" alt="X" height="16"
												width="16">
										</c:otherwise>

									</c:choose></td>

								<td><c:choose>
										<c:when test="${admins.deleteTopicPermission == true}">
											<img src="images/button_ok.png" alt="ok" height="16"
												width="16">
										</c:when>
										<c:otherwise>
											<img src="images/button_cancel.png" alt="X" height="16"
												width="16">
										</c:otherwise>

									</c:choose></td>

								<td><c:choose>
										<c:when test="${admins.deleteUserPermission == true}">
											<img src="images/button_ok.png" alt="ok" height="16"
												width="16">
										</c:when>
										<c:otherwise>
											<img src="images/button_cancel.png" alt="X" height="16"
												width="16">
										</c:otherwise>

									</c:choose></td>

								<td><c:choose>
										<c:when test="${admins.activationUserPernmision == true}">
											<img src="images/button_ok.png" alt="ok" height="16"
												width="16">
										</c:when>
										<c:otherwise>
											<img src="images/button_cancel.png" alt="X" height="16"
												width="16">
										</c:otherwise>

									</c:choose></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>




			</div>
		</div>


	</div>







</body>
</html>