<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Towar</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Towar</h1>
				<p>Dodaj towar</p>
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
		<form:form  modelAttribute="newProduct" class="form-horizontal">
			<fieldset>
				<legend>Dodaj nowy towar</legend>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId">Id</label>
					<div class="col-lg-10">
						<form:input id="productId" path="productId" type="text" class="form:input-large"/>
					</div>
				</div>		
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="name">Nazwa</label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="quantity">Ilość</label>
					<div class="col-lg-10">
						<form:input id="quantity" path="quantity" type="number" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="netto">Netto</label>
					<div class="col-lg-10">
						<form:input id="netto" path="netto" type="number" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="brutto">Brutto</label>
					<div class="col-lg-10">
						<form:input id="brutto" path="brutto" type="number" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="tax">Tax</label>
					<div class="col-lg-10">
						<form:input id="tax" path="tax" type="number" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Dodaj"/>
					</div>
					<p><a href="<spring:url value="/products/all" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> wstecz
					</a></p>
				</div>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>
