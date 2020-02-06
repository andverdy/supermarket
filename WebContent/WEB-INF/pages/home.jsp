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
		&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
		&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
		&nbsp &nbsp &nbsp&nbsp &nbsp  --|| SUPERMARKET SHOP ONLINE ||--
	</h1>

	&nbsp &nbsp &nbsp&nbsp &nbsp &nbsp&nbsp &nbsp &nbsp&nbsp &nbsp &nbsp
	&nbsp &nbsp &nbsp&nbsp &nbsp &nbsp&nbsp &nbsp &nbsp
	&nbsp &nbsp &nbsp&nbsp &nbsp &nbsp&nbsp &nbsp &nbsp
	&nbsp &nbsp &nbsp&nbsp &nbsp &nbsp&nbsp &nbsp &nbsp
	<img src="https://www.centroclinicoclarense.it/wp-content/uploads/2015/11/psicologo-fobia-supermercato.jpg" alt="Mia Immagine">
          <p>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
           &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp${messageInsert}
          </p>
	<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>

	<form method="get">
		<button  formaction="FormViewServ">Inserisci Nuovo Articolo</button>		
	</form> <br>


	<!--   <form action="/FormViewServ?param=<&='1'%" method="post">
		<input type="submit" name="InsBotton" value="Inserisci Articolo">
		
	</form>

	<form action="/FormViewServ?param=<&='2'%" method="post">
		<input type="submit" name="EditBotton" value="Modifica Articolo">
		
	</form> -->

	<table>
		<tr>
			<th>Codice Articolo</th>
			<th>Descrizione</th>
			<th>PzCart</th>
			<th>Iva</th>
			<th>FamAssort</th>
		</tr>

		<c:forEach items="${articleList}" var="article">
			<tr>
				<td>&nbsp&nbsp&nbsp&nbsp&nbsp ${article.codArt}
					&nbsp&nbsp&nbsp</td>

				<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					${article.descrizione}
					</td>

				<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					${article.pzCart}&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp

				<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					${article.ivaDesc}
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>

				<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					${article.famAssDesc}&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>

				<td>
				
					<form method="post">
						<button value="${article.codArt}" name="getCod" formaction="FormViewServ">Modifica Articolo</button>
					</form> 
		</c:forEach>

	</table>
</body>
</html>