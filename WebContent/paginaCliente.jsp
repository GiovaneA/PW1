<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RiverValley Web Company Ltda.</title>
</head>
<body>
<h1>Pagina do Cliente</h1>
<h3><% // recuperar o nome do cliente ou da empresa do banco de dados %> Nome C</h3>
<h4>Servicos Contratados</h4>
<select name="servicos">
		<%
			//listar os servicos
			
		%>
		<option value= '0'>Nenhum Servico</option>
		</select> <br><br>
		<input type="submit" value="Acessar Servico">
<h4>Contratar Servicos</h4>
	<ul>
		<li> <a href="formContaPoupanca.jsp">Criar Conta Poupanca</a>
		<li> <a href="formContaCorrente.jsp">Criar Conta Corrente</a>
		<li> <a href="formSeguro.jsp">Solicitar Seguro</a>
	</ul>
</body>
</html>