<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Fakutra</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Fakutra</h1>
				<p>Dodaj fakturę</p>
				<p>
					<a href="<spring:url value="/products/all" />" class="btn btn-default">
						<span class="glyphicon glyphicon glyphicon-shopping-cart"></span> towary</a>					
					<a href="<spring:url value="/sellers/all" />" class="btn btn-default">
							<span class="glyphicon glyphicon-euro"></span> sprzedawcy</a>
					<a href="<spring:url value="/clients/all" />" class="btn btn-default">
							<span class="glyphicon glyphicon-user"></span> klienci</a>					
				</p>
			</div>			
		</div>
	</section>
	<section class="container">
		<form:form modelAttribute="newDocument" class="form-horizontal">
			<fieldset>
				<legend>Dodaj nową fakturę</legend>				
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="documentId">Id</label>
					<div class="col-lg-10">
						<form:input id="documentId" path="documentId" type="number" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="documentNumber">Numer</label>
					<div class="col-lg-10">
						<form:input id="documentNumber" path="documentNumber" type="number" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="city">Miejscość</label>
					<div class="col-lg-10">
						<form:input id="name" path="city" type="text" class="form:input-large"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="date">Data dokumentu</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="unitPrice" path="date" type="text" class="form:input-large"/>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="payment">Sposób płatności</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="unitPrice" path="payment" type="text" class="form:input-large"/>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="term">Termin płatności</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="unitPrice" path="term" type="text" class="form:input-large"/>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="clientId">Klient</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:select path="clientId">
				                <form:option value="-" label="--Wybierz klienta"/>
				                <form:options items="${clientsMap}" />
				            </form:select>
			        	</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="sellerId">Sprzedawca</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:select path="sellerId">
				                <form:option value="-" label="--Wybierz sprzedawcę"/>
				                <form:options items="${sellersMap}" />
				            </form:select>
			        	</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Dodaj"/>
					</div>
					<p><a href="<spring:url value="/documents/all" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> wstecz
					</a></p>
				</div>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>
