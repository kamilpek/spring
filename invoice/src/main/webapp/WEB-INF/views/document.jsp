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
					<span class="glyphicon glyphicon-plus"></span> dodaj produkt</a></p>
				<p>					
					<a href="<spring:url value="/documents/all" />" class="btn btn-default">
							<span class="glyphicon glyphicon-file"></span> faktury</a>
					<a href="<spring:url value="/sellers/all" />" class="btn btn-default">
							<span class="glyphicon glyphicon-euro"></span> sprzedawcy</a>
					<a href="<spring:url value="/clients/all" />" class="btn btn-default">
							<span class="glyphicon glyphicon-user"></span> klienci</a>					
				</p>
				<hr>
				
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
				<h3>Numer: ${document.documentId}</h3>				
				<p><strong>Netto</strong>: ${document.netto}</p>
				<p><strong>Brutto</strong>: ${document.brutto}</p>
				<p><strong>VAT</strong>: ${document.tax}</p>
				<p>
					<strong>Klient</strong>: ${client.name}
					<a
						href="<spring:url value="/clients/client?id=${client.clientId}" /> "
						class="btn btn-primary btn-sm"> <span
						class="glyphicon-info-sign glyphicon" /></span> Szczegóły
					</a>
				</p>
				<p>
					<strong>Sprzedawca</strong>: ${seller.name}
					<a
						href="<spring:url value="/sellers/seller?id=${seller.sellerId}" /> "
						class="btn btn-primary btn-sm"> <span
						class="glyphicon-info-sign glyphicon" /></span> Szczegóły
					</a>
				</p>	
			</div>
		</div>
		<hr>
		<div>
			<a
				href="<spring:url value="/documents/calc?id=${document.documentId}" /> "
				class="btn btn-primary btn-sm"> <span
				class="glyphicon-info-sign glyphicon" /></span> Przelicz fakturę
			</a>
			<a
				href="<spring:url value="/documents/pdf?id=${document.documentId}" /> "
				class="btn btn-primary btn-sm"> <span
				class="glyphicon-info-sign glyphicon" /></span> Generuj PDF
			</a>
		</div>
		<hr>
		<h3>Lista towarów</h3>
		<div class="row">			
			<c:forEach items="${products}" var="product">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${product.name}</h3>							
							<p>PLN netto: ${product.netto}, brutto: ${product.brutto}</p>							
							<p>
								<a
									href="<spring:url value="/products/product?id=${product.productId}" /> "
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
