<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario de Pessoa Fisica</title>
</head>
<body>
	<h3>Formulario de Pessoa Fisica</h3>
	<form action="sistema?logica=CadastrarPessoaFisica" method="post">
		Nome: <br>
		<input type="text" name="nome" > <br><br>
		Endereço: <br>
		<input type="text" name="endereco"> <br><br>
		Telefone: <br>
		<input type="text" name="telefone"> <br><br>
		CPF: <br>
		<input type="text" name="cpf"> <br><br>
		Nome do Pai: <br>
		<input type="text" name="nomePai"> <br><br>
		Nome da Mãe: <br>
		<input type="text" name="nomeMae"> <br><br>
		
		</select> <br><br>
		<input type="submit" value="Cadastrar Pessoa Fisica">
	</form>
</body>
</html>