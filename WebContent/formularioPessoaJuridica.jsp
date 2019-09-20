
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Pessoa Juridica</title>
</head>
<body>
	<h3>Formulario de cadastro de pessoa juridica</h3>
	<form action="sistema?logica=CadastrarClienteJ" method="post">
		Nome: <br>
		<input type="text" name="nome" > <br><br>
		Endereço: <br>
		<input type="text" name="endereco"> <br><br>
		Telefone: <br>
		<input type="text" name="telefone"> <br><br>
		CNPJ: <br>
		<input type="text" name="cnpj"> <br><br>
		Nome Fantasia: <br>
		<input type="text" name="nomeFantasia"> <br><br>

		 <br><br>
		<input type="submit" value="Cadastrar">
	</form>
</body>
</html>