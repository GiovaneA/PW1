<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Criar Conta Corrente</title>
</head>
<body>
	<%String id = request.getParameter("id"); %>
	<h3>Criar Conta Corrente</h3>
	<h4>Para que sua conta seja ativada, voce deve depositar qualquer
		quantia em dinheiro.</h4>
	<form action="sistema?logica=CriarContaCorrente" method="post">
		Valor a ser depositado: <br> R$ <input type="number" name="valor">
		<br>
		<br> <input type=hidden name="idCliente" value="<%=id%>"><br>
		<input type="submit" value="Ativar">
	</form>
</body>
</html>