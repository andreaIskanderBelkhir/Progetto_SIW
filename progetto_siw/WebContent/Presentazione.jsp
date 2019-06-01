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
<nav>
<form action ="FormController" method="post">
Cerca per autore<input type="text" name="autore" /><button type="submit">Invia</button></form>
</nav>
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
<aside>Carrello:
<ul><c:forEach var="foto" items="${carrello.foto}"><li>${foto.id}</li></c:forEach></ul>
<a href="Contratto.jsp"><button type="submit">Conferma</button></a>
</aside>
</body>
</html>