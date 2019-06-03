<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<h1>StockImages</h1>
<nav><div><a href="GestisciFotografo.jsp">aggiungi o rimuovi un fotografo</a></div>
<div><a href="GestisciAlbum.jsp">aggiungi o rimuovi un album</a></div></nav>
<div>richieste ricevute:</div>
<table>
<tr><th>Id richiesta</th><th>Nome richiedente</th><th>Cognome richiedente</th></tr>
<c:forEach var="richiesta" items="${admin.richieste}">
<tr><td>${richiesta.id}</td><td>${richiesta.nomeRichiedente}</td><td>${richiesta.cognomeRichiedente}</td></tr>
</c:forEach>
</table>
</body>
</html>