<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Klienci</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Klienci</h1>
				<p><a href="<spring:url value="/clients/add" />" class="btn btn-default">
					<span class="glyphicon glyphicon-plus"></span> dodaj klienta</a></p>
				<p>
					<a href="<spring:url value="/products/all" />" class="btn btn-default">
						<span class="glyphicon glyphicon glyphicon-shopping-cart"></span> towary</a>
					<a href="<spring:url value="/documents/all" />" class="btn btn-default">
							<span class="glyphicon glyphicon-file"></span> faktury</a>					
					<a href="<spring:url value="/sellers/all" />" class="btn btn-default">
							<span class="glyphicon glyphicon-euro"></span> sprzedawcy</a>				
				</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<c:forEach items="${clients}" var="client">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${client.name}</h3>							
							<p>NIP: ${client.nip}, ${client.city}, ${client.street}</p>							
							<p>
								<a
									href="<spring:url value="/clients/client?id=${client.clientId}" /> "
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
