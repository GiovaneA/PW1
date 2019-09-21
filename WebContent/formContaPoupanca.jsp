<%@page import="com.giovanealvares.projeto1pwi.model.PessoaFisica"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Criar Poupanca</title>
</head>
<body>
<%PessoaFisica pf = (PessoaFisica) request.getAttribute("clienteLogado");
request.setAttribute("clienteLogado", pf); %>
	<h3>Criar Poupanca</h3>
	<h4>Para que sua conta seja ativada, voce deve depositar qualquer quantia em dinheiro.</h4>
	<form action="sistema?logica=CriarContaPoupanca" method="post">
		Valor a ser depositado: <br>
		R$ <input type="number" name="valor" > <br><br>
		 
		<input type="submit" value="Ativar">
	</form>
</body>
</html>