<%@page import="sk.tsystems.jada.forum.entity.services.PersonService"%>
<%@page import="sk.tsystems.jada.forum.entity.Person"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
				<ul class="nav nav-tabs navbar-right">

					<c:choose>
						<c:when test="${orderBy == 1 }">
							<li role="presentation"><a
								href="/JADA_Tsystems_TeamProject/ShowUsers?ordebBy=name">ABC...</a></li>
							<li role="presentation" class="active"><a
								href="/JADA_Tsystems_TeamProject/ShowUsers?ordebBy=dType">Type</a></li>
							<li role="presentation"><a
								href="/JADA_Tsystems_TeamProject/ShowUsers?ordebBy=activ">Activate</a></li>
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
								href="/JADA_Tsystems_TeamProject/ShowUsers?ordebBy=activ">Activate</a></li>
							<li role="presentation"><a
								href="/JADA_Tsystems_TeamProject/ShowUsers?ordebBy=rDate">Reg.
									Date</a></li>
						</c:when>

						<c:when test="${orderBy == 3 }">
							<li role="presentation"><a
								href="/JADA_Tsystems_TeamProject/ShowUsers?ordebBy=name">ABC...</a></li>
							<li role="presentation"><a
								href="/JADA_Tsystems_TeamProject/ShowUsers?ordebBy=dType">Type</a></li>
							<li role="presentation"><a
								href="/JADA_Tsystems_TeamProject/ShowUsers?ordebBy=activ">Activate</a></li>
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
								href="/JADA_Tsystems_TeamProject/ShowUsers?ordebBy=activ">Activate</a></li>
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
								href="/JADA_Tsystems_TeamProject/ShowUsers?ordebBy=activ">Activate</a></li>
							<li><a
								href="/JADA_Tsystems_TeamProject/ShowUsers?ordebBy=rDate">Reg.
									Date</a></li>

						</c:otherwise>
					</c:choose>
				</ul>
				<table class="table table-striped table-inverse">
					<thead>
						<tr>
							<th>User Name</th>

							<th>Full Name</th>

							<th>Email</th>

							<th>B.Day</th>

							<th>Registration Date</th>

							<th></th>
						</tr>
					</thead>
					<tbody id="usersList">
						<c:forEach items="${persons}" var="persons" varStatus="theCount">
							<c:choose>
								<c:when test="${persons.personName ne 'Removed User'}">
									<tr>
										<td><c:choose>
												<c:when
													test="${persons.getClass().name.equals('sk.tsystems.jada.forum.entity.Admin')}">
													<img src="images/admin.ico" alt="admin" height="25"
														width="25">
												</c:when>
												<c:when
													test="${persons.getClass().simpleName eq 'SuperAdmin'}">
													<img src="images/superAdmin.ico" alt="admin" height="25"
														width="25">
												</c:when>
												<c:otherwise>
													<img src="images/user.ico" alt="user" height="25"
														width="25">
												</c:otherwise>

											</c:choose> <b><i>${persons.personName}</i></b></td>

										<td>${persons.fullName}</td>

										<td>${persons.email}</td>

										<td><p>
												<fmt:formatDate value="${persons.birthday}"
													pattern="dd.MMM yyy HH:mm" />
											</p></td>
										<td><p>
												<fmt:formatDate value="${persons.registrationDate}"
													pattern="dd.MMM yyy HH:mm" />
											</p></td>
										<td><c:if
												test="${persons.getClass().simpleName ne 'SuperAdmin'}">

												<c:choose>

													<c:when test="${persons.active}">

														<c:choose>
															<c:when
																test="${user.getClass().name.equals('sk.tsystems.jada.forum.entity.SuperAdmin') || user.deleteUserPermission}">
																<form method="post">
																	<input type="hidden" name="delete"
																		value="${persons.personName}"> <input
																		type="submit" value="DELETE"
																		class="btn btn-danger btn-block" />
																</form>
															</c:when>
														</c:choose>

														<c:choose>
															<c:when
																test="${user.getClass().name.equals('sk.tsystems.jada.forum.entity.SuperAdmin') || user.activationUserPernmision}">
																<form method="post">
																	<input type="hidden" name="dissable"
																		value="${persons.personName}"> <input
																		type="submit" value="DISSABLE"
																		class="btn btn-warning btn-block" />
																</form>
															</c:when>
														</c:choose>
													</c:when>


													<c:otherwise>

														<c:choose>
															<c:when
																test="${user.getClass().name.equals('sk.tsystems.jada.forum.entity.SuperAdmin') || user.deleteUserPermission}">
																<form method="post">
																	<input type="hidden" name="delete"
																		value="${persons.personName}"> <input
																		type="submit" value="DELETE"
																		class="btn btn-danger btn-block" />
																</form>
															</c:when>
														</c:choose>

														<c:choose>
															<c:when
																test="${user.getClass().name.equals('sk.tsystems.jada.forum.entity.SuperAdmin') || user.activationUserPernmision}">
																<form method="post">
																	<input type="hidden" name="activate"
																		value="${persons.personName}"> <input
																		type="submit" name="activate" value="ACTIVATE"
																		class="btn btn-success btn-block" />
																</form>
															</c:when>
														</c:choose>
													</c:otherwise>

												</c:choose>
											</c:if></td>
									</tr>
								</c:when>
							</c:choose>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-md-12 text-center">
				<ul class="pagination pagination-md pager" id="numberOfPage"></ul>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/numberOfPage.js"></script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>