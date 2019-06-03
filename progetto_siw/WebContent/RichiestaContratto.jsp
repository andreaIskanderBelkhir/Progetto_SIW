<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<h1><b>StockImages</b></h1>
<h2>Form di richiesta licenza royalty-free</h2>
<form action="richiestaController" method="post">
<div>Nome :<input type="text" name="nome"> <span class="error">${nomeErr}</span> </div>
<div>Cognome : <input type="text" name="cogonome"> <span class="error">${cognomeErr}</span> </div>
<div>Data di nascita : <input type="date" name="dataDiNascita"><span class="error">${dataErr}</span></div>
<div><button type="submit">Invia</button></div></form>
</body>
</html>