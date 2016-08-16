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

			<div class="center">
				<form method="get">
					<input type="hidden" name="adminName" value="${adminName}">

					<c:choose>
						<c:when test="${admin.activationUserPernmision == true}">
											Activate USER <label class="checkbox-inline"> <input
								type="checkbox" value="true" name="activateUser"
								checked="checked"> ENABLE
							</label>
							<br>
						</c:when>
						<c:otherwise>
											Activate USER <label class="checkbox-inline"> <input
								type="checkbox" value="true" name="activateUser"> ENABLE
							</label>
							<br>
						</c:otherwise>

					</c:choose>



					<c:choose>
						<c:when test="${admin.deleteCommentPermission == true}">
											Delete Comment <label class="checkbox-inline"> <input
								type="checkbox" value="true" name="deleteComment"
								checked="checked"> ENABLE
							</label>
							<br>
						</c:when>
						<c:otherwise>
											Delete Comment <label class="checkbox-inline"> <input
								type="checkbox" value="true" name="deleteComment">
								ENABLE
							</label>
							<br>
						</c:otherwise>

					</c:choose>

					<c:choose>
						<c:when test="${admin.deleteTopicPermission == true}">
											Delete Topic <label class="checkbox-inline"> <input
								type="checkbox" value="true" name="deleteTopic"
								checked="checked"> ENABLE
							</label>
							<br>
						</c:when>
						<c:otherwise>
									Delete Topic <label class="checkbox-inline"> <input
								type="checkbox" value="true" name="deleteTopic"> ENABLE
							</label>
							<br>
						</c:otherwise>

					</c:choose>

					<c:choose>
						<c:when test="${admin.deleteUserPermission == true}">
											Delete USER <label class="checkbox-inline"> <input
								type="checkbox" value="true" name="deleteUser" checked="checked">
								ENABLE
							</label>
							<br>
						</c:when>
						<c:otherwise>
									Delete USER <label class="checkbox-inline"> <input
								type="checkbox" value="true" name="deleteUser"> ENABLE
							</label>
							<br>
						</c:otherwise>

					</c:choose>

					<input type="submit" name="save" value="Save">
				</form>
			</div>
		</div>
	</div>
</body>
</html>