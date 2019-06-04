<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<h1>
		<b>StockImages</b>
	</h1>
	<div>Inserisci le credenziali per entrare come Admin</div>
	<form
		action="<%out.println(response.encodeURL("LogInController"));%>"
		method="get">
		<div>
			<%
				out.println("Id");
			%>
			<input type="text" name="id" value="${param.id}" /> <span
				class="error"> ${idErr} </span>
		</div>
		<div>
			<%
				out.println("Password"); 
			%>
			<input type="password" name="password" value="${param.password}" /> <!--Per togliere pass sbagliata togliere value--> <span
				class="error"> ${passwordErr} </span>
		</div>
		<div>
			<span class="error"> ${idpasErr} </span>
		</div>
		<button type="submit">
			<%
				out.println("Invia");
			%>
		</button>
	</form>
</body>
</html>