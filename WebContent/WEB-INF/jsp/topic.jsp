<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Topic-JADA</title>

<link rel="stylesheet" type="text/css"
	href="css/jquery.dataTables.min.css">
</head>
<body>

		<jsp:include page="header.jsp"></jsp:include>
		
	<%-- 	<c:forEach items="${topicComments}" var="comment">
			<p>${comment.getPerson.getPersonName}</p>
		</c:forEach> --%>

		<div>
			<form>
				<label for="comment">Comment:</label> <br>
				<textarea name="comment" spellcheck="true" cols="52" rows="10"
					required title="Content." placeholder="Article content"></textarea>
				<br> <br> <input type="submit">
			</form>
		</div>


	<script src="//code.jquery.com/jquery-1.12.3.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
	<script src='js/dataTables.js'></script>
</body>
</html>
