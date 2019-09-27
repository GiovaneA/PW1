
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Pessoa Fisica</title>
</head>
<body>
	<h3>Formulario de cadastro de pessoa fisica</h3>
	<form action="sistema?logica=CadastrarClienteF" method="post">
		Nome: <br>
		<input type="text" name="nome" required> <br><br>
		Endereço: <br>
		<input type="text" name="endereco" required> <br><br>
		Telefone: <br>
		<input type="text" name="telefone" required> <br><br>
		CPF: <br>
		<input type="text" name="cpf" required> <br><br>
		Nome do Pai: <br>
		<input type="text" name="nomePai" required> <br><br>
		Nome da Mãe: <br>
		<input type="text" name="nomeMae" required> <br><br>
		
		<br><br>
		<input type="submit" value="Cadastrar" required>
	</form>
</body>
</html>