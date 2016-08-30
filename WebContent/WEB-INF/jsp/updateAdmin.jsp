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


			<!-- Modal -->
			<div class="modal fade" id="myModal" role="dialog"
				data-backdrop="static" data-keyboard="false">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<!-- <button type="button" class="close" data-dismiss="modal">&times;</button> -->
							<h2 class="modal-title text-center formHead">
								Edit Admin permission user:<b> ${adminName }</b>
								</h4>
						</div>
						<div class="modal-body">


							<div class="panel panel-default">
								<div class="panel-body">
									<form method="get" class="form-horizontal">
										<input type="hidden" name="adminName" value="${adminName}">
										<div class="panel panel-default">
											<div class="panel-body">
												<div class="form-group">
													<c:choose>
														<c:when test="${admin.activationUserPernmision == true}">

															<label class="form-check-label "> <input
																type="checkbox" value="true" name="activateUser"
																checked="checked"> Activate User persmision
															</label>


														</c:when>
														<c:otherwise>

															<label class=class="form-check-label"> <input
																type="checkbox" value="true" name="activateUser">
																Activate User persmision
															</label>

														</c:otherwise>

													</c:choose>
												</div>

												<div class="form-group">
													<c:choose>
														<c:when test="${admin.deleteCommentPermission == true}">

															<label class="form-check-label"> <input
																type="checkbox" value="true" name="deleteComment"
																checked="checked"> Delete comment permission
															</label>

														</c:when>
														<c:otherwise>

															<label class="form-check-label"> <input
																type="checkbox" value="true" name="deleteComment">
																Delete comment permission
															</label>

														</c:otherwise>

													</c:choose>
												</div>
												<div class="form-group">
													<c:choose>
														<c:when test="${admin.deleteTopicPermission == true}">

															<label class="form-check-label"> <input
																type="checkbox" value="true" name="deleteTopic"
																checked="checked"> Delete topic permission
															</label>

														</c:when>
														<c:otherwise>

															<label class="form-check-label"> <input
																type="checkbox" value="true" name="deleteTopic">
																Delete topic permission
															</label>

														</c:otherwise>

													</c:choose>
												</div>
												<div class="form-group">
													<c:choose>
														<c:when test="${admin.deleteUserPermission == true}">

															<label class="form-check-label"> <input
																type="checkbox" value="true" name="deleteUser"
																checked="checked"> Delete user persmission
															</label>

														</c:when>
														<c:otherwise>

															<label class="form-check-label"> <input
																type="checkbox" value="true" name="deleteUser">
																Delete user persmission
															</label>

														</c:otherwise>

													</c:choose>
												</div>
											</div>
										</div>
										<div class="text-center">
											<div class="btn-group ">
												<input type="submit" name="save" value="Save changes"
													class="btn btn-primary btn-block"> <a
													href="showAdminsPermission"
													class="btn btn-info btn-block"> Cancel </a>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<a href="showAdminsPermission"
								class="btn btn-default">Close</a>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
	$(window).load(function() {
		$('#myModal').modal('show');
	});
</script>
<script type="text/javascript">
	$(window).load(function() {
		$('#myModal').modal('show');
	});
</script>
</html>