<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<link rel="stylesheet" href="/css/custom.css"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<title>Artykuły</title>
</head>
<body>
	<section>			
		<div class="container">
			<h1 class="header"> Lista artykułów </h1><hr>			
		</div>
	</section>

	<section class="container">
		<table class="table table-striped">
			<thead class="thead-light">
				<tr>
			      <th scope="col">#</th>
			      <th scope="col">Tytuł</th>
			      <th scope="col">Dodany</th>
			      <th scope="col">Autor</th>
			      <th scope="col">Akcje</th>
			    </tr>
			</thead>
			<tbody>
				<c:forEach items="${articles}" var="article">
					<tr>
						<td>${article.articleID}</td>
						<td>${article.title}</td>
						<td>${article.created}</td>
						<td>${article.author}</td>
						<td><a href="<spring:url value="/articles/article?id=${article.articleID}" /> "
							class="btn btn-sm btn-success"> Więcej </a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p><a href="<spring:url value="/articles/add"/>" class="btn btn-block btn btn-outline-success">Dodaj Artykuł</a></p>
		<p><a href="<spring:url value="/" /> " class="btn btn-block btn-outline-primary "> Strona Główna</a></p>
	</section>
</body>
</html>
