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
	<title>${greeting}</title>
</head>
	<body>
		<section>			
			<div class="container">
				<h1 class="header"> ${greeting} </h1><hr>
			</div>
		</section>
		<c:forEach items="${articles}" var="article">
			<section>		
				<div class="container">
					<h3>${article.title}</h3>
					<p class="articles-header">${article.intro}</p>
					<p class="articles-btn"><a href="<spring:url value="/articles/article?id=${article.articleID}" /> "
					   class="btn btn-sm btn-outline-primary "> Czytaj więcej...</a></p>
					<hr>
				</div>
			</section>
		</c:forEach>
		<section>			
			<div class="container">
				<c:choose>
				    <c:when test="${permission}">				         
				        <a href="<spring:url value="/logout" /> " class="btn btn-sm btn-outline-danger "> Wyloguj</a>
				    </c:when>    
				    <c:otherwise>
				        <a href="<spring:url value="/login" /> " class="btn btn-sm btn-outline-success "> Zaloguj</a>
				    </c:otherwise>
				</c:choose>
			</div>
		</section>
	</body>
</html>