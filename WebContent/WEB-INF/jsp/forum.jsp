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

		<div class="container-fluid text-center">
			<div class="row content">
				<div class="col-sm-1 sidenav">
					<p>
						<a href="#">Link</a>
					</p>
					<p>
						<a href="#">Link</a>
					</p>
					<p>
						<a href="#">Link</a>
					</p>
				</div>
				<div class="col-sm-7 text-left">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">@</span> <input
							type="text" class="form-control" placeholder="Username"
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

		<section class="content">
		<h1>Table Filter</h1>
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="pull-right">
						<div class="btn-group">
							<c:forEach items="${topKeyWords}" var="keyWord">
								<button type="button" class="btn btn-filter"">testkeyword:
									${keyWord.keyWord }</button>
							</c:forEach>

						</div>
					</div>
					<div class="table-container">
						<table class="table table-filter">
							<tbody>
								<c:forEach items="${topics}" var="topic">
									<tr>
										<td>
											<div class="well">
												<div>Topic rating:${topic }</div>

												<div class="btn-group" role="group" aria-label="...">
													<button type="button" class="btn btn-success">
														<span class="glyphicon glyphicon-thumbs-up"
															aria-hidden="true"></span>
													</button>
													<button type="button" class="btn btn-danger">
														<span class="glyphicon glyphicon-thumbs-down"
															aria-hidden="true"></span>
													</button>
												</div>
											</div>
										</td>
										<td><div class="media-body">
												<h3>
													<a href="#">${topic.topicName }</a><span class="pull-right">(${topic.person.personName })</span>
												</h3>
												<p>${topic.topicDescription}</p>
												<span class="pull-right">${topic.topicDate }</span>
												<c:forEach items="${topic.keyWords}" var="keyword">
													<button class="btn btn-sm-info">${keyword.keyWord }</button>
												</c:forEach>
											</div> <!-- 											<div class="media-body"> --> <!-- 												<h4> -->
											<%-- 													${topic.topicName } <span class="pull-right pagado">(${topic.person.personName })</span> --%>
											<!-- 												</h4> --> <!-- 											</div> --></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>

		</div>
		</section>

		<div class="content-footer">
			<p>
				JadaForum © - 2016 <br> Powered By <a href="#" target="_blank">JaDA</a>
			</p>
		</div>
	</div>
</body>
</html>