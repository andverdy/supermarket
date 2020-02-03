<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supermarket</title>
</head>

<body>
	<h1>
		<br>
		<br>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
		&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
		&nbsp &nbsp &nbsp --|| SUPERMARKET SHOP ONLINE ||--
	</h1>
	<br>
	<br>
	<br>

	<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>

	<form method="get">
		<td>
			<button formaction="FormViewServ">Inserisci Nuovo Articolo</button>
		</td>
	</form> <br>

	<table>
		<tr>
			<th>Codice Articolo</th>
			<th>Descrizione</th>
			<th>PzCart</th>
			<th>IdIva</th>
			<th>IdFamAss</th>

		</tr>

		<c:forEach items="${articlesList}" var="listArticles">
			<tr>
				<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp ${listArticles.codArt}
					&nbsp&nbsp&nbsp&nbsp</td>

				<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					${listArticles.descrizione}
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>

				<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					${listArticles.pzCart}&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp

				
				<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					${listArticles.idIva}
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>


				<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					${listArticles.idFamAss}&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>



			</tr>
		</c:forEach>


	</table>
</body>
</html>