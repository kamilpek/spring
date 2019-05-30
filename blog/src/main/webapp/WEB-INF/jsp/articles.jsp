<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Artykuły</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Artykuły</h1>
				<p><a href="<spring:url value="/articles/add" />" class="btn btn-default">
					<span class="glyphicon glyphicon-plus"></span> dodaj artykuł</a></p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<c:forEach items="${articles}" var="article">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${article.title}</h3>							
							<p>${article.author}</p>							
							<p>
								<a
									href="<spring:url value="/articles/article?id=${article.articleID}" /> "
									class="btn btn-primary"> <span
									class="glyphicon-info-sign glyphicon" /></span> Szczegóły
								</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>
