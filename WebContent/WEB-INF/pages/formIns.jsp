<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Articoli</title>
</head>
<body>

	<br><br>
	
	<h1>&nbsp&nbsp&nbsp&nbsp&nbsp GESTIONE ARTICOLI SUPERMARKET</h1>
	<br>
	<br>
	<form method="post">
		<label for="cod">Codice Articolo</label><br> 
		<input id="cod" type="text" name="codice"><br> <br> 
		
		<label for="descr">Descrizione</label><br>
		<input id="descr" type="text" name="descriz"><br>
		
		<br> <label for="pz">Pezzi per cartone</label><br>
		 <input id="pz" name="pezziCart"><br>
		<br>

	<label for="cod">Iva</label><br>
		<select name="iva">
	<c:forEach items="${ivaList}" var="listIva">
			<tr>    
				<option  value= "${listIva.getIdIva()}">${listIva.getDescrizione()}</option>
			</tr>  
		</c:forEach>
	</select> <br> <br>


		<label for="cod">Famiglia Assortimento</label><br>
		<select name="fam">
		<c:forEach items="${listFms}" var="listFamAssort">
			<tr>
				<option value="${listFamAssort.getId()}">${listFamAssort.getDescrizione()}</option>
			</tr>
		</c:forEach>
	</select>
		
		<br> <br><br>
		<button formaction="InsArticle">Inserisci</button>

	</form>

</body>

<p></p>
</html>