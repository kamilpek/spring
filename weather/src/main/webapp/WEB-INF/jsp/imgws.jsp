<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Pomiary IMGW</title>
</head>
<body>
	<br>
	<section class="container">	
		<div class="panel panel-default">
		  <div class="panel-heading">
			  <h2>
				  Pomiary IMGW
				  <a href="<spring:url value="/imgws/download" />" class="btn btn-success">
							<span class="glyphicon glyphicon-plus"></span> pobierz</a>
			  </h2>
		  </div>
		  <div class="panel-body">
		   		<p>Godzina podawana jest w UTC.</p>
		  </div>
		  <table class="table table-hover">
		    <tr>
			    <th>Miasto</th>
			    <th>Godzina</th> 
		    	<th>Data</th>
		    	<th>Temperatura</th>
		    	<th>Prędkość wiatru</th>
		    	<th>Suma opadu</th>
		    	<th>Ciśnienie</th>
		    	<th>Akcje</th>
			</tr>
			<c:forEach items="${imgws}" var="imgw">
			<tr>
				<td>${imgw.stacja}</td>
				<td>${imgw.godzina}</td> 
				<td>${imgw.data}</td>
				<td>${imgw.temperatura}&#176;C</td>
				<td>${imgw.predkosc_wiatru} mm/s</td>
				<td>${imgw.suma_opadu} mm/h</td>
				<td>${imgw.cisnienie} hPa</td>
				<td><a href="<spring:url value="/imgws/${imgw.id}" /> " class="btn btn-sm btn-primary"> 
					<span class="glyphicon-info-sign glyphicon" /></span> Szczegóły </a></td>
			</tr>
			</c:forEach>
		  </table>
		</div>
	</section>
</body>
</html>
