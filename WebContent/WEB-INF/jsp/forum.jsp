<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forum-JADA</title>

<link rel="stylesheet" type="text/css"
	href="css/jquery.dataTables.min.css">
</head>
<body>
	<div class="container">
	<a href="http://github.com/aehlke/tag-it"><img style="position: absolute; top: 0; right: 0; border: 0;" src="http://s3.amazonaws.com/github/ribbons/forkme_right_white_ffffff.png" alt="Fork me on GitHub" /></a>
	
		<jsp:include page="header.jsp"></jsp:include>

		<div class="container-fluid text-center">
			<div class="row content">
				<div class="col-sm-1 sidenav">
					<p>
						<a href="/JADA_Tsystems_TeamProject/newtopic">ASK QUESTION</a>
					</p>
					<p>
						<a href="#">placeholder</a>
					</p>
					<p>
						<a href="#">placeholder</a>
					</p>
				</div>
				<div class="col-sm-7 text-left">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">@</span> <input
							type="text" class="form-control" placeholder="Username" name=""
							aria-describedby="basic-addon1">
					</div>
				</div>
				<div class="col-sm-4 sidenav">
					<div class="well">
						<div id="myCarousel" class="carousel slide" data-ride="carousel">
							<!-- Indicators -->
							<ol class="carousel-indicators">
								<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
								<li data-target="#myCarousel" data-slide-to="1"></li>
								<li data-target="#myCarousel" data-slide-to="2"></li>
								<li data-target="#myCarousel" data-slide-to="3"></li>
							</ol>

							<!-- Wrapper for slides -->
							<div class="carousel-inner" role="listbox"
								style="max-height: 20rem; min-height: 25rem">
								<div class="item active">
									<img src="images/joke1.png" alt="joke1.png">
								</div>

								<div class="item">
									<img src="images/joke2.png" alt="joke2.png">
								</div>

								<div class="item">
									<img src="images/joke3.png" alt="joke3.png">
								</div>

								<div class="item">
									<img src="images/joke4.png" alt="joke4.png">
								</div>
							</div>

							<!-- Left and right controls -->
							<a class="left carousel-control" href="#myCarousel" role="button"
								data-slide="prev"> <span
								class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
								<span class="sr-only">Previous</span>
							</a> <a class="right carousel-control" href="#myCarousel"
								role="button" data-slide="next"> <span
								class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
								<span class="sr-only">Next</span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="panel panel-default">
			<div class="panel-body">
				<table id="topicList" class="display" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>topic</th>
							<!-- 							<th>description</th> -->
							<!-- 							<th>date</th> -->
							<!-- 							<th>author</th> -->
							<!-- 							<th>keywords</th> -->
						</tr>
					</thead>
					<c:forEach items="${topics}" var="topic">
						<tr>
							<%-- 							<td>${topic.topicName }</td> --%>
							<%-- 							<td>${topic.topicDescription}</td> --%>
							<%-- 							<td>${topic.topicDate }</td> --%>
							<%-- 							<td>${topic.person.personName }</td> --%>
							<%-- 							<td>${keyword.keyWord }</td> --%>

							<td><div class="media-body">

									<h3>
										<a href="#">${topic.topicName }</a><span class="pull-right">(${topic.person.personName })</span>
									</h3>
									<p>${topic.topicDescription}</p>
									<span class="pull-right">${topic.topicDate }</span>
									<c:forEach items="${topic.keyWords}" var="keyword">
										<button class="btn btn-sm-info">${keyword.keyWord }</button>
									</c:forEach>
								</div></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>



		<div class="content-footer">
			<p>
				JadaForum © - 2016 <br> Powered By <a href="#" target="_blank">JaDA</a>
			</p>
		</div>
	</div>

	<script src="//code.jquery.com/jquery-1.12.3.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
	<script src='js/dataTables.js'></script>
</body>
</html>