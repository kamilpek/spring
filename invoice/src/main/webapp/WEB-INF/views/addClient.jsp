<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Klient</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Klient</h1>
				<p>Dodaj klienta</p>
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
		<form:form  modelAttribute="newClient" class="form-horizontal">
			<fieldset>
				<legend>Dodaj nową fakturę</legend>				
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="clientId">Id</label>
					<div class="col-lg-10">
						<form:input id="clientId" path="clientId" type="number" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="nip">Nazwa</label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="nip">NIP</label>
					<div class="col-lg-10">
						<form:input id="nip" path="nip" type="text" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="city">Miejscość</label>
					<div class="col-lg-10">
						<form:input id="city" path="city" type="text" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="street">Ulica</label>
					<div class="col-lg-10">
						<form:input id="street" path="street" type="text" class="form:input-large"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="post">Poczta</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="post" path="post" type="text" class="form:input-large"/>
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
