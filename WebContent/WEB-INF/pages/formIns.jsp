<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Articoli</title>
</head>
<body>

<br><br>

			<h1>  &nbsp&nbsp&nbsp&nbsp&nbsp 
			GESTIONE ARTICOLI SUPERMARKET</h1> <br> <br>
	<form method="get">
		<label for="cod">Codice Articolo</label><br>
		<input id="cod" type="text" name="cod"><br> <br>
		
		<label for="descr">Descrizione</label><br>
		<input id="descr" type="text" name="desc"><br><br>
		
		<label for="pz">Pezzi per cartone</label><br>
		<input id="pz" name="pzCart"><br><br>
		
		
		<!--  <label for="iva">Iva:</label> <br> 
		<input type="text" id="iva" name="iva" list="iva_list">
		<datalist id="iva_list">
			<option value="1">IVA ESENTE</option>
			<option value="2">IVA RIVENDITA 4%</option>
			<option value="3">IVA RIVENDITA 10%</option>
			<option value="4">IVA RIVENDITA 22%</option>
		</datalist> <br> <br> -->
		
		<label>Iva</label> <br>
		<select> <!-- Iva -->
 		 	<option value="volvo">Volvo</option>  
 			<option value="saab">Saab</option>
  			<option value="opel">Opel</option>
  			<option value="audi">Audi</option>
		</select> <br> <br>
		
		
		<label>Famiglia Assortimento</label> <br>
		<select>  <!-- FamAssort -->
 		 	<option value="iva">Volvo</option>
 			<option value="saab">Saab</option>
  			<option value="opel">Opel</option>
  			<option value="audi">Audi</option>
  			
  			
		</select>
		<!--
		<label for="fam">Famiglia Assortimento:</label> <br> 
		<input type="text" id="fam" name="fam" list="fam_list">
		<datalist id="fam_list">
			<option value="1">DROGHERIA ALIMENTARE</option>
			<option value="2">DROGHERIA CHIMICA</option>
			<option value="3">BANCO TAGLIO</option>
			<option value="4">GASTRONOMIA</option>
			<option value="5">PASTICCERIA</option>
			<option value="6">LIBERO SERVIZIO</option>
			<option value="7">PANE</option>
			<option value="8">SURGELATI</option>
			<option value="9">ORTOFRUTTA</option>
			<option value="10">MACELLERIA</option>
			<option value="11">PESCHERIA</option>
			<option value="12">EXTRA ALIMENTARI</option>
		</datalist> <br> <br> -->
		<br> <br><br> <br>
		<button formaction="inserisci">Inserisci</button>
		
	</form>


</body>
</html>