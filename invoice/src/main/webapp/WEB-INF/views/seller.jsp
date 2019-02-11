<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Sprzedawca</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Sprzedawca</h1>
				<p><a href="<spring:url value="/sellers/add" />" class="btn btn-default">
					<span class="glyphicon glyphicon-plus"></span> dodaj sprzedawce
				</a></p>				
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
				<h3>${seller.name}</h3>				
				<p><strong>NIP</strong>:${seller.nip}</p>
				<p><strong>Miasto</strong>: ${seller.city}</p>
				<p><strong>Ulica</strong>: ${seller.street}</p>
				<p><a href="<spring:url value="/sellers/all" />" class="btn btn-default">
					<span class="glyphicon-hand-left glyphicon"></span> wstecz
				</a></p>
			</div>
		</div>
	</section>
</body>
</html>
