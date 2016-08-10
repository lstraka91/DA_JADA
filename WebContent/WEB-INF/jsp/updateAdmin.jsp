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
			
					<tr>
						<td>Activate USER</td>
						<td><label class="checkbox-inline"><input
								type="checkbox" value="">ENABLE</label> <label
							class="checkbox-inline"> <input type="checkbox" value="">DISABLE
						</label></td>

					</tr>
					<tr>
						<td>Delete Comment</td>
						<td><label class="checkbox-inline"><input
								type="checkbox" value="">ENABLE</label> <label
							class="checkbox-inline"> <input type="checkbox" value="">DISABLE
						</label></td>

					</tr>
					<tr>

						<td>Delete Topic</td>
						<td><label class="checkbox-inline"><input
								type="checkbox" value="">ENABLE</label> <label
							class="checkbox-inline"> <input type="checkbox" value="">DISABLE
						</label></td>

					</tr>
					<tr>
						<td>Delete USER</td>
						<td><label class="checkbox-inline"><input
								type="checkbox" value="">ENABLE</label> <label
							class="checkbox-inline"> <input type="checkbox" value="">DISABLE
						</label></td>

					</tr>


				</tbody>
			</table>

					
			<form method="post" action=" ">
					<div class="panel-body">
						<h2 class="text-center formHead">Edit Admin</h2>

						<center>
							<div class="form-group">

								<input type="text" name="userName" id="userName"
									value="${admin.personName}"
									class="form-control input-lg" required />
								<div id="status"></div>
							</div>
							<div class="form-group">

								<input type="text" name="fullName"
									value="${admin.fullName}"
									class="form-control input-lg" required />
							</div>
							<div class="form-group">

						
						
							<div class="form-group">

								<input type="email" name="Email"
									value="${admin.email}"
									class="form-control input-lg" required />
							</div>
							<input type="submit" value="Register RRRRuser" id="register"
								class="btn btn-lg btn-block btn-success" /> <a
								href="/JADA_Tsystems_TeamProject/login"
								class="btn btn-lg btn-block btn-primary">UPDATE</a>
						</center>
					</div>
				</form>
			
			
			
		</div>


	</div>
</body>
</html>