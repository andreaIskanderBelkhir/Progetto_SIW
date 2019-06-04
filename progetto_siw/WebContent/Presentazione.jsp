<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="StileCSS.css">
<title>StockImages</title>
</head>
<body>
<header><b>StockImages</b></header>
<section>
<c:forEach var="fotografo" items="${fotografo}">
<div>Album: ${fotografo.album.nome} di ${fotografo.nome}</div>
<ol>
<c:forEach var="foto" items="${fotografo.album.foto}">
<li><a href="selezionaFoto?id=${foto.id}"><img alt="${foto.id}" src="${foto}">></a></li>
</c:forEach>
</ol>
</c:forEach>
</section>
<aside>
<form action ="FormController" method="post">
<div>Cerca per fotografo<input type="text" name="autore" /></div>
<div>Cerca una foto<input type="text" name="foto" /></div>
<div>Cerca un album<input type="text" name="album" /></div>
<div><span class="error">${ricercaErr}</span></div>
<div><button type="submit">Invia</button></div></form></aside>
<aside>
<div>Carrello:</div>
<ul><c:forEach var="foto" items="${carrello.foto}"><li>${foto.id}</li></c:forEach></ul>
<a href="RichiestaContratto.jsp"><button type="submit">Conferma</button></a>
</aside>
<footer>
Autori: Andrea Belkir / Omar Moh'd / Giacomo Bellini
</footer>
</body>
</html>