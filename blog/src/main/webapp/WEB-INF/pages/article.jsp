<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/css/custom.css"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<title>${article.title}</title>
</head>
<body>
	<section>			
		<div class="container">
			<h1 class="header"> ${article.title} </h1><hr>
		</div>
	</section>
	<section>		
		<div class="container">
			<p>Napisał: ${article.author}</p><hr>			
		</div>
	</section>
	<section class="container">		
		<p>${article.intro}</p>
		<hr>		
	</section>	
	<section class="container">		
		<p>${article.content}</p>
		<hr>
	</section>
	<section class="container">
		<p><a href="<spring:url value="/" />" class="btn btn-block btn-primary">Strona Główna</a></p>
	</section>
</body>
</html>
