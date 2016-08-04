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
					<h1>Welcome</h1>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat. Excepteur sint occaecat
						cupidatat non proident, sunt in culpa qui officia deserunt mollit
						anim id est laborum consectetur adipiscing elit, sed do eiusmod
						tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
						minim veniam, quis nostrud exercitation ullamco laboris nisi ut
						aliquip ex ea commodo consequat.</p>
					<hr>
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
		<div class="col-md-10">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="pull-right">
						<div class="btn-group">
							${topics}
							<c:forEach items="${topKeyWords}" var="keyWord">
								<button type="button" class="btn btn-filter"">testkeyword:
									${keyWord.keyWord }</button>
							</c:forEach>

						</div>
					</div>
					<div class="table-container">
						<table class="table table-filter">
							<tbody>
								<tr data-status="pagado">
									<td>
										<div class="ckbox">
											<input type="checkbox" id="checkbox1"> <label
												for="checkbox1"></label>
										</div>
									</td>
									<td><a href="javascript:;" class="star"> <i
											class="glyphicon glyphicon-star"></i>
									</a></td>
									<td>
										<div class="media">
											<a href="#" class="pull-left"> <img
												src="https://s3.amazonaws.com/uifaces/faces/twitter/fffabs/128.jpg"
												class="media-photo">
											</a>
											<div class="media-body">
												<span class="media-meta pull-right">Febrero 13, 2016</span>
												<h4 class="title">
													Lorem Impsum <span class="pull-right pagado">(Pagado)</span>
												</h4>
												<p class="summary">Ut enim ad minim veniam, quis nostrud
													exercitation...</p>
											</div>
										</div>
									</td>
								</tr>
								<tr data-status="pendiente">
									<td>
										<div class="ckbox">
											<input type="checkbox" id="checkbox3"> <label
												for="checkbox3"></label>
										</div>
									</td>
									<td><a href="javascript:;" class="star"> <i
											class="glyphicon glyphicon-star"></i>
									</a></td>
									<td>
										<div class="media">
											<a href="#" class="pull-left"> <img
												src="https://s3.amazonaws.com/uifaces/faces/twitter/fffabs/128.jpg"
												class="media-photo">
											</a>
											<div class="media-body">
												<span class="media-meta pull-right">Febrero 13, 2016</span>
												<h4 class="title">
													Lorem Impsum <span class="pull-right pendiente">(Pendiente)</span>
												</h4>
												<p class="summary">Ut enim ad minim veniam, quis nostrud
													exercitation...</p>
											</div>
										</div>
									</td>
								</tr>
								<tr data-status="cancelado">
									<td>
										<div class="ckbox">
											<input type="checkbox" id="checkbox2"> <label
												for="checkbox2"></label>
										</div>
									</td>
									<td><a href="javascript:;" class="star"> <i
											class="glyphicon glyphicon-star"></i>
									</a></td>
									<td>
										<div class="media">
											<a href="#" class="pull-left"> <img
												src="https://s3.amazonaws.com/uifaces/faces/twitter/fffabs/128.jpg"
												class="media-photo">
											</a>
											<div class="media-body">
												<span class="media-meta pull-right">Febrero 13, 2016</span>
												<h4 class="title">
													Lorem Impsum <span class="pull-right cancelado">(Cancelado)</span>
												</h4>
												<p class="summary">Ut enim ad minim veniam, quis nostrud
													exercitation...</p>
											</div>
										</div>
									</td>
								</tr>
								<tr data-status="pagado" class="selected">
									<td>
										<div class="ckbox">
											<input type="checkbox" id="checkbox4" checked> <label
												for="checkbox4"></label>
										</div>
									</td>
									<td><a href="javascript:;" class="star star-checked">
											<i class="glyphicon glyphicon-star"></i>
									</a></td>
									<td>
										<div class="media">
											<a href="#" class="pull-left"> <img
												src="https://s3.amazonaws.com/uifaces/faces/twitter/fffabs/128.jpg"
												class="media-photo">
											</a>
											<div class="media-body">
												<span class="media-meta pull-right">Febrero 13, 2016</span>
												<h4 class="title">
													Lorem Impsum <span class="pull-right pagado">(Pagado)</span>
												</h4>
												<p class="summary">Ut enim ad minim veniam, quis nostrud
													exercitation...</p>
											</div>
										</div>
									</td>
								</tr>
								<tr data-status="pendiente">
									<td>
										<div class="ckbox">
											<input type="checkbox" id="checkbox5"> <label
												for="checkbox5"></label>
										</div>
									</td>
									<td><a href="javascript:;" class="star"> <i
											class="glyphicon glyphicon-star"></i>
									</a></td>
									<td>
										<div class="media">
											<a href="#" class="pull-left"> <img
												src="https://s3.amazonaws.com/uifaces/faces/twitter/fffabs/128.jpg"
												class="media-photo">
											</a>
											<div class="media-body">
												<span class="media-meta pull-right">Febrero 13, 2016</span>
												<h4 class="title">
													Lorem Impsum <span class="pull-right pendiente">(Pendiente)</span>
												</h4>
												<p class="summary">Ut enim ad minim veniam, quis nostrud
													exercitation...</p>
											</div>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="content-footer">
				<p>
					Page © - 2016 <br> Powered By <a
						href="https://www.facebook.com/tavo.qiqe.lucero" target="_blank">TavoQiqe</a>
				</p>
			</div>
		</div>
		</section>

		<footer class="container-fluid text-center">
		<p>Footer Text</p>
		</footer>
	</div>
</body>
</html>