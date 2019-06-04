<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<link rel="stylesheet" href="/css/custom.css"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<title>Nowy artykuł</title>
</head>
<body>
	<section>			
		<div class="container">
			<h1 class="header"> Nowy artykuł </h1><hr>
		</div>
	</section>

	<section class="container">
		<form:form  modelAttribute="newArticle" enctype="multipart/form-data" class="form-horizontal">
			<fieldset>						
				
				<div class="form-group">
					<label class="control-label" for="title">Tytuł</label>					
					<form:input id="title" path="title" type="text" class="form-control"/>				
				</div>
				
				<div class="form-group">
					<label class="control-label" for="author">Autor</label>					
					<form:input id="author" path="author" type="text" class="form-control"/>					
				</div>
				
				<div class="form-group">
					<label class="control-label" for="intro">Intro</label>					
					<form:textarea id="intro" path="intro" rows="3" class="form-control"/>					
				</div>
				
				<div class="form-group">
					<label class="control-label" for="content">Treść</label>
					<form:textarea id="content" path="content" rows="3" class="form-control"/>					
				</div>
				
				<div class="form-group">
					<label class="control-label" for="content">Ilustracja</label>
					<input type="file" name="imageFile" class="form-control">					
				</div>			
				
				<div class="form-group">
					<p><input type="submit" id="btnAdd" class="btn btn-block btn-success" value ="Dodaj artykuł"/></p>
					<p><a href="<spring:url value="/articles/all" />" class="btn btn-block btn-secondary">Powrót</a></p>
				</div>
			
			</fieldset>
		</form:form>	
		
	</section>
</body>
</html>
