<%@page import="sk.tsystems.jada.forum.entity.services.PersonService"%>
<%@page import="sk.tsystems.jada.forum.entity.Person"%>
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


		<table class="table table-hover">

			<thead>

				<tr>

					<th></th>

					<th>User Name</th>

					<th>Email</th>

					<th>Active</th>

				</tr>

			</thead>

			<tbody>
				<c:forEach items="${persons}" var="persons" varStatus="theCount">
					<tr>

						<td><c:choose>
								<c:when
									test="${persons.getClass().name.equals('sk.tsystems.jada.forum.entity.Admin')}">
									<img src="images/admin.ico" alt="admin" height="25" width="25">
								</c:when>
								<c:otherwise>
									<img src="images/user.ico" alt="user" height="25" width="25">
								</c:otherwise>

							</c:choose></td>

						<td><b><i>${persons.personName}</i></b></td>

						<td>${persons.email}</td>

						<td><c:choose>
								<c:when test="${persons.active == true}">
									<form method="post">
										<input type="hidden" name="delete"
											value="${persons.personName}"> <input type="submit"
											value="DELETE" class="btn btn-danger" />
									</form>

								</c:when>
								<c:otherwise>
									<form method="post">
										<input type="hidden" name="delete"
											value="${persons.personName}"> <input type="submit"
											value="DELETE" class="btn btn-danger" />
									</form>
									<form method="post">
										<input type="hidden" name="activate"
											value="${persons.personName}"> <input type="submit"
											name="activate" value="ACTIVATE" class="btn btn-success" />
									</form>
								</c:otherwise>
							</c:choose></td>

					</tr>
				</c:forEach>
			</tbody>

		</table>



		<button type="submit" class="btn btn-primary">Submit</button>







	</div>

</body>
</html>