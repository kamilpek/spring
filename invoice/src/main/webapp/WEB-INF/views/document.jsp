<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Faktura</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Faktura</h1>
				<p><a href="<spring:url value="/products/add" />" class="btn btn-default">
					<span class="glyphicon glyphicon-plus"></span> dodaj produkt
				</a></p>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
				<h3>${document.documentId}</h3>				
				<p><strong>Netto </strong>:${document.netto}</p>
				<p><strong>Brutto</strong>: ${document.brutto}</p>
				<p><strong>VAT</strong>: ${document.tax}</p>
				<p><strong>Klient</strong>: ${document.clientId}</p>
				<p><strong>Sprzedawca</strong>: ${document.sellerId}</p>
				<p><a href="<spring:url value="/documents/all" />" class="btn btn-default">
					<span class="glyphicon-hand-left glyphicon"></span> wstecz
				</a></p>
			</div>
		</div>
	</section>
</body>
</html>
