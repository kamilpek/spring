<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Nowy artykuł</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Nowy artykuł</h1>
			</div>
		</div>
	</section>

	<section class="container">
		<form:form  modelAttribute="newArticle" class="form-horizontal">
			<fieldset>
				<legend>Dodaj nową fakturę</legend>				
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="title">Tytuł</label>
					<div class="col-lg-10">
						<form:input id="title" path="title" type="text" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="author">Autor</label>
					<div class="col-lg-10">
						<form:input id="author" path="author" type="text" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="intro">Intro</label>
					<div class="col-lg-10">
						<form:input id="intro" path="intro" type="textarea" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="content">Treść</label>
					<div class="col-lg-10">
						<form:input id="content" path="content" type="textarea" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Dodaj"/>
					</div>
					<a href="<spring:url value="/articles/all" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> wstecz
					</a>
				</div>				
			
			</fieldset>
		</form:form>
	</section>
</body>
</html>
