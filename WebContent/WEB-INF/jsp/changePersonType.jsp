<%@page import="sk.tsystems.jada.forum.entity.services.PersonService"%>
<%@page import="sk.tsystems.jada.forum.entity.Person"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forum-JADA</title>
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="panel panel-default">
			<div class="panel-body">
				<ul class="nav nav-tabs navbar-right">

					<c:choose>
						<c:when test="${orderBy == 1 }">
							<li role="presentation"><a
								href="/JADA_Tsystems_TeamProject/ShowUsers?ordebBy=name">ABC...</a></li>
							<li role="presentation" class="active"><a
								href="/JADA_Tsystems_TeamProject/ShowUsers?ordebBy=dType">Type</a></li>
							<li role="presentation"><a
								href="/JADA_Tsystems_TeamProject/ShowUsers?ordebBy=rDate">Reg.
									Date</a></li>

						</c:when>

						<c:when test="${orderBy == 2 }">
							<li role="presentation"><a
								href="/JADA_Tsystems_TeamProject/ShowUsers?ordebBy=name">ABC...</a></li>
							<li role="presentation"><a
								href="/JADA_Tsystems_TeamProject/ShowUsers?ordebBy=dType">Type</a></li>
							<li role="presentation" class="active"><a
								href="/JADA_Tsystems_TeamProject/ShowUsers?ordebBy=rDate">Reg.
									Date</a></li>
						</c:when>


						<c:when test="${orderBy == 4 }">
							<li role="presentation" class="active"><a
								href="/JADA_Tsystems_TeamProject/ShowUsers?ordebBy=name">ABC...</a></li>
							<li role="presentation"><a
								href="/JADA_Tsystems_TeamProject/ShowUsers?ordebBy=dType">Type</a></li>
							<li role="presentation"><a
								href="/JADA_Tsystems_TeamProject/ShowUsers?ordebBy=rDate">Reg.
									Date</a></li>
						</c:when>

						<c:otherwise>

							<li><a
								href="/JADA_Tsystems_TeamProject/ShowUsers?ordebBy=name">ABC...</a></li>
							<li><a
								href="/JADA_Tsystems_TeamProject/ShowUsers?ordebBy=dType">Type</a></li>
							<li><a
								href="/JADA_Tsystems_TeamProject/ShowUsers?ordebBy=rDate">Reg.
									Date</a></li>

						</c:otherwise>
					</c:choose>
				</ul>


				<table class="table table-striped table-inverse responsive">

					<thead>

						<tr>

							<th>Role</th>

							<th>User Name</th>
							<th>Full Name</th>

							<th>Email</th>

							<th>Registration Date</th>

							<th></th>

						</tr>

					</thead>

					<tbody>
						<c:forEach items="${persons}" var="persons" varStatus="theCount">
							<tr>
								<td><c:choose>
										<c:when
											test="${persons.getClass().simpleName.equals('Admin')}">
											<img src="images/admin.ico" alt="admin" height="25"
												width="25">

										</c:when>
										<c:when
											test="${persons.getClass().simpleName.equals('SuperAdmin')}">
											<img src="images/superAdmin.ico" alt="admin" height="25"
												width="25">

										</c:when>
										<c:otherwise>
											<img src="images/user.ico" alt="user" height="25" width="25">
										</c:otherwise>

									</c:choose> <b> ${persons.getClass().simpleName }</b></td>

								<td><b><i>${persons.personName}</i></b></td>
								<td><i>${persons.fullName}</i></td>

								<td>${persons.email}</td>

								<td><p>
										<fmt:formatDate value="${persons.registrationDate}"
											pattern="dd.MMM yyy HH:mm" />
									</p></td>

								<td><c:choose>
										<c:when
											test="${persons.getClass().simpleName.equals('SuperAdmin') }">
											<a href="#">
												<div class="btn btn-default disabled">Set as
													SuperAdmin</div>
											</a>
										</c:when>
										<c:otherwise>
											<a
												href="changePersonType?changeTo=superAdmin&personName=${persons.personName}">
												<div class="btn btn-info">Set as SuperAdmin</div>
											</a>
										</c:otherwise>
									</c:choose></td>
								<td><c:choose>
										<c:when
											test="${persons.getClass().simpleName.equals('Admin') }">
											<a href="#">
												<div class="btn btn-default disabled">Set as Admin</div>
											</a>
										</c:when>
										<c:otherwise>
											<a
												href="changePersonType?changeTo=admin&personName=${persons.personName}">
												<div class="btn btn-info">Set as Admin</div>
											</a>
										</c:otherwise>
									</c:choose></td>
								<td><c:choose>
										<c:when
											test="${persons.getClass().simpleName.equals('Person') }">
											<a href="#">
												<div class="btn btn-default disabled">Set as Person</div>
											</a>
										</c:when>
										<c:otherwise>
											<a
												href="changePersonType?changeTo=person&personName=${persons.personName}">
												<div class="btn btn-info">Set as Person</div>
											</a>
										</c:otherwise>
									</c:choose></td>
							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>