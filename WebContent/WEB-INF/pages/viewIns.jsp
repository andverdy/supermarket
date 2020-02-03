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
	<h1>--|| Gestione Articoli ||--</h1>


	<p>_________________________________________</p>

	<p>
	<form name="invio_dati" action="URL_personalizzata" method="post">

		<p>

			<input type="submit" value="Inserisci"> 
			<input type="submit" value="Modifica"> 
			<input type="submit" value="Elimina">
			<input type="submit" value="Aggiorna">
		</p>

		<p>
			<input name="codArt" placeholder="Codice Articolo">
		</p>
		<p>
			<input name="descrizione" placeholder="Descrizione">
		</p>
		<p>
			<input name="pzCart" placeholder="Pezzi per cartone">
		</p>
		<p>
			<input name="idIva" placeholder="Id iva">
		</p>
		<p>
			<input name="idStatoArt" placeholder="Id stato articolo">
		</p>
		<p>
			<input name="idFamAss" placeholder="Id famiglia assortimento">
		</p>





	</form>



	<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>

</body>
</html>