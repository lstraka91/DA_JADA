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
  <h2>EDIT ADMINS</h2>
  
  <table class="table">
    <thead>
      <tr>
        <th>Admins DETAILS</th>
        <th>NEW DETAILS</th>
        <th>Email</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td> <%= request.getParameter("personName")%></td>
        <td>Doe</td>
        <td>john@example.com</td>
      </tr>
      <tr>
        <td> <%= request.getParameter("fullName")%></td>
        <td>Moe</td>
        <td>mary@example.com</td>
      </tr>
      <tr>
        <td> <%= request.getParameter("birthday")%></td>
        <td>Dooley</td>
        <td>july@example.com</td>
      </tr>
      <tr>
        <td> <%= request.getParameter("deleteCommentr")%></td>
        <td>Doe</td>
        <td>john@example.com</td>
      </tr>
      <tr>
        <td> <%= request.getParameter("deleteUser")%></td>
        <td>Doe</td>
        <td>john@example.com</td>
      </tr>
      <tr>
        <td> <%= request.getParameter("deleteTopic")%></td>
        <td>Doe</td>
        <td>john@example.com</td>
      </tr>
      <tr>
        <td> <%= request.getParameter("activatedUser")%></td>
        <td>Doe</td>
        <td>john@example.com</td>
      </tr>
      
    </tbody>
  </table>
</div>
		
		
		request.setAttribute("personName", admin.getPersonName());
		request.setAttribute("fullName", admin.getFullName());
		request.setAttribute("birthday", admin.getBirthday());
		request.setAttribute("email", admin.getEmail());
		request.setAttribute("deleteCommentr", admin.isDeleteCommentPermission());
		request.setAttribute("deleteUser", admin.isDeleteUserPermission());
		request.setAttribute("deleteTopic", admin.isDeleteTopicPermission());
		request.setAttribute("activatedUser", admin.isActivationUserPernmision());
		
		
		
		
</div>
</body>
</html>