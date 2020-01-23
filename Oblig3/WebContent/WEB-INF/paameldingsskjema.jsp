<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<style>body {background-color: #d0f0f2;}</style>
<title>Påmelding</title>
</head>
<body>
	<h2>Påmelding</h2>
	<p> Vær ops på at fornavn og etternavn må starte med storbokstav </p>
	
	<p>
		<font color="red">${registreringsMessage}</font>
	</p>
	
	<form method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> <input 
					type="text"
					name="fornavn" value="${skjema.fornavn}" /> 
					<font color="red">${skjema.feilFornavn}</font>
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> <input 
					type="text"
					name="etternavn" value="${skjema.etternavn}" /> 
					<font color="red">${skjema.feilEtternavn}</font>
			</div>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> <input 
					type="text"
					name="mobil" value="${skjema.mobil}" /> 
					<font color="red">${skjema.feilMobil}</font>
			</div>
			<div class="pure-control-group">
				<label for="password">Passord:</label> <input 
					type="password"
					name="passord" value="${skjema.passord1}" /> 
					<font color="red">${skjema.feilPassord1}</font>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> <input
					type="password" name="passordRepetert"
					value="${skjema.passord2}" /> 
					<font color="red">${skjema.feilPassord2}</font>
			</div>
			<div class="pure-control-group">
				<label for="kjonn">Kjønn:</label> 
					<input type="radio" name="kjonn" value="mann" />Mann
					<input type="radio" name="kjonn" value="kvinne"/>Kvinne
				<font color="red">${skjema.feilKjonn}</font>
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Meld
					meg på</button>
			</div>
		</fieldset>
	</form>
</body>
</html>