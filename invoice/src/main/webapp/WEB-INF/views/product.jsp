<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Towar</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Towar</h1>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
				<h3>${product.name}</h3>				
				<p><strong>Netto </strong>:${product.netto}</p>
				<p><strong>Brutto</strong>: ${product.brutto}</p>
				<p><strong>VAT</strong>: ${product.tax}</p>
				<p><strong>Ilość</strong>: ${product.quantity}</p>
				<p><strong>Suma Netto</strong>: ${product.sumNetto}</p>
				<p><strong>Suma Brutto</strong>: ${product.sumBrutto}</p>
				<p><strong>Suma VAT</strong>: ${product.sumTax}</p>
				<p>
					<a href="#" class="btn btn-warning btn-large"> <span
						class="glyphicon-shopping-cart glyphicon"></span> Zamów teraz
					</a> <a href="<spring:url value="/products/all" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> wstecz
					</a>

				</p>

			</div>
		</div>
	</section>
</body>
</html>
