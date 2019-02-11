<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Towary</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Towary</h1>	
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
			</div>
		</div>
	</section>

	<section class="container">
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
