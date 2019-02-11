<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<title>Witaj</title>
</head>
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1> ${greeting} </h1>
					<p> ${tagline} </p>
					<hr>
					<p>
						<a href="<spring:url value="/products/all" />" class="btn btn-default">
							<span class="glyphicon glyphicon-barcode"></span> lista towarów</a>
						<a href="<spring:url value="/products/add" />" class="btn btn-default">
							<span class="glyphicon glyphicon-plus"></span> dodaj towar</a>						
					</p>					
					<p>
						<a href="<spring:url value="/documents/all" />" class="btn btn-default">
							<span class="glyphicon glyphicon-file"></span> lista faktur</a>
						<a href="<spring:url value="/documents/add" />" class="btn btn-default">
							<span class="glyphicon glyphicon-plus"></span> dodaj fakture</a>
					</p>
					<p>
						<a href="<spring:url value="/sellers/all" />" class="btn btn-default">
							<span class="glyphicon glyphicon-euro"></span> lista sprzedawców</a>						
						<a href="<spring:url value="/sellers/add" />" class="btn btn-default">
							<span class="glyphicon glyphicon-plus"></span> dodaj sprzedawce</a>
					</p>
					<p>
						<a href="<spring:url value="/clients/all" />" class="btn btn-default">
							<span class="glyphicon glyphicon-user"></span> lista klientów</a>
						<a href="<spring:url value="/clients/add" />" class="btn btn-default">
							<span class="glyphicon glyphicon-plus"></span> dodaj klienta</a>
					</p>					
				</div>
			</div>
		</section>
	</body>
</html>
