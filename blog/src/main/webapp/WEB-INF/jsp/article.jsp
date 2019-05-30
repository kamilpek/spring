<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Artykuł</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>${article.title}</h1>
				<p>Autor: ${article.author}</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<p>${article.intro}</p>			
		</div>
	</section>
	<hr>
	<section class="container">
		<div class="row">
			<p>${article.content}</p>			
		</div>
	</section>	
</body>
</html>
