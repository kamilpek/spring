<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Pomiar IMGW</title>
</head>
<body>
	<br>
	<section class="container">	
		<div class="panel panel-default">
		  <div class="panel-heading">
			  <h2>
				  Pomiar IMGW ze stacji ${imgw.stacja}
				  <a href="<spring:url value="/imgws/all" />" class="btn btn-sm btn-default">
							<span class="glyphicon glyphicon-list"></span> powrót do listy</a>
			  </h2>
		  </div>
		  <div class="panel-body">
		   		<p>ID stacji: ${imgw.id_stacji}</p>
		  </div>
		  <table class="table table-hover">
		    <tr>
			    <th>Paramter</th>
			    <th>Wartość</th>
			    <th>Jednostka</th>
			</tr>			
			<tr>
				<td>Godzina</td>
				<td>UTC</td>
				<td>${imgw.godzina}</td>
			</tr>
			<tr>
				<td>Data</td>
				<td> </td>
				<td>${imgw.data}</td>
			</tr>
			<tr>
				<td>Temperatura</td>
				<td>&#176;C</td>
				<td>${imgw.temperatura}</td>
			</tr>
			<tr>
				<td>Predkość Wiatru</td>
				<td>m/s</td>
				<td>${imgw.predkosc_wiatru}</td>
			</tr>
			<tr>
				<td>Suma opadów</td>
				<td>mm/h</td>
				<td>${imgw.suma_opadu}</td>
			</tr>
			<tr>
				<td>Ciśnienie</td>
				<td>hPa</td>
				<td>${imgw.cisnienie}</td>
			</tr>
		  </table>
		</div>
	</section>
</body>
</html>
