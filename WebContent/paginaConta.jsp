<%@page import="com.giovanealvares.projeto1pwi.model.Conta"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conta</title>
</head>
<body>
	<%
		Conta conta = (Conta) request.getAttribute("conta");
		request.setAttribute("conta", conta);
		String id = Integer.toString(conta.getId());
		String tipo = null;
		switch (conta.getTipo()) {
		case 1:
			tipo = "Corrente";
		case 2:
			tipo = "Poupanca";
		}%>
	
	<h2>Conta <%=tipo%> de numero <%=conta.getNumero()%></h2>
	<h3>Selecione a operacao que deseja realizar</h3>
	<h4>Depositar</h4>
		<form action="sistema?logica=Depositar" method="post">
		Valor a ser depositado: <br>
		R$ <input type="number" name="valor" >
		<input type="hidden" name="id" value="<%=id%>" >
		<br>
		<br>
		<input type="submit" value="Depositar">
	</form>
	<br>
	<br>
		<h4>Sacar</h4>
		<form action="sistema?logica=Sacar" method="post">
		Valor a ser Sacado: <br>
		R$ <input type="number" name="valor" >
		<input type="hidden" name="id" value="<%=id%>" >
		<br>
		<br>
		<input type="submit" value="Sacar">
	</form>
	<br>
	<br>
			<h4>Desativar Conta</h4>
		<form action="sistema?logica=Desativar" method="post">
		<!-- Se realmente deseja desativar esta conta digite DESATIVAR abaixo <br> 
		<input type="text" name="confirmacao" >
		<br>
		<br>
		-->
		<input type="hidden" name="id" value="<%=id%>" >
		<input type="submit" value="Desativar">
	</form>
	<br>
	<br>
		<h4>Ativar Conta</h4>
		<form action="sistema?logica=Ativar" method="post">
		<!--Se realmente deseja ativar esta conta digite ATIVAR abaixo <br>
		<input type="text" name="confirmacao" >
		<br>
		<br>
		-->
		<input type="hidden" name="id" value="<%=id%>" >
		<input type="submit" value="Ativar">
	</form>
	<br>
	<br>
</body>
</html>